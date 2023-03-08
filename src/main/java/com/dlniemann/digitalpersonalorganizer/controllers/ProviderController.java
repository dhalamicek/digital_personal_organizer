package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.Provider;
import com.dlniemann.digitalpersonalorganizer.models.data.MedicationsRepository;
import com.dlniemann.digitalpersonalorganizer.models.data.PatientRepository;
import com.dlniemann.digitalpersonalorganizer.models.data.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


//*should I change providers to add a column for
//medical, legal, financial, etc and pull lists from there or get rid of provider repository altogether and add provider type
//to contacts and pull lists from there?
@Controller
@RequestMapping("view/{patientId}/providers")
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
        return "index";
    }



    @GetMapping("view/{patientId}/providers/{providerId}")
    public String displayViewProvider(Model model, @PathVariable int providerId) {

        Optional optProvider = providersRepository.findById(providerId);
        if (optProvider.isPresent()) {
            Provider provider = (Provider) optProvider.get();
            model.addAttribute("provider", provider);
            return "view/{patientId}/providers";
        } else {
            return "redirect:../";
        }
    }
}
