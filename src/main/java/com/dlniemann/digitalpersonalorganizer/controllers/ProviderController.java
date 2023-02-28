package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.Provider;
import com.dlniemann.digitalpersonalorganizer.models.data.MedicationsRepository;
import com.dlniemann.digitalpersonalorganizer.models.data.PatientRepository;
import com.dlniemann.digitalpersonalorganizer.models.data.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;



@Controller
@RequestMapping("providers")
public class ProviderController {

    @Autowired
    private ProvidersRepository providersRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicationsRepository medicationsRepository;


    @GetMapping("")
    public String displayAllProviders(Model model) {
        model.addAttribute("title", "All Providers");
        model.addAttribute("providers", providersRepository.findAll());
        return "providers/index";
    }

    @GetMapping("add")
    public String displayAddProviderForm(Model model) {
        model.addAttribute("title", "Add Provider");
        model.addAttribute("provider", new Provider());
        model.addAttribute("providerRole", providersRepository.findAll());
        model.addAttribute("providerName", providersRepository.findAll());
        model.addAttribute("providerName", providersRepository.findAll());
        model.addAttribute("providerPhoneNumber", providersRepository.findAll());

        return "providers/add";
    }

    @PostMapping("add")
    public String processAddProviderForm(@ModelAttribute @Valid Provider newProvider, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Provider");
            return "providers/add";
        }
        providersRepository.save(newProvider);
        return "redirect:";
    }

    @GetMapping("view/{providerId}")
    public String displayViewProvider(Model model, @PathVariable int providerId) {

        Optional optProvider = providersRepository.findById(providerId);
        if (optProvider.isPresent()) {
            Provider provider = (Provider) optProvider.get();
            model.addAttribute("provider", provider);
            return "providers/view";
        } else {
            return "redirect:../";
        }
    }
}
