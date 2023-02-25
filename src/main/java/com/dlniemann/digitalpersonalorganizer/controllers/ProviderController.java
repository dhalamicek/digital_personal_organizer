package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.Provider;
import com.dlniemann.digitalpersonalorganizer.models.data.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


//does add/edit/delete go in this controller or the admincontroller?
@Controller
@RequestMapping("medical/providers")
public class ProviderController {

    @Autowired
    private ProvidersRepository providersRepository;


    @GetMapping("")
    public String displayAllProviders(Model model) {
        model.addAttribute("title", "All Providers");
        model.addAttribute("providers", providersRepository.findAll());
        return "medical/providers/index";
    }

    @GetMapping("view/{providerId}")
    public String displayViewProvider(Model model, @PathVariable int providerId) {

        Optional optProvider = providersRepository.findById(providerId);
        if (optProvider.isPresent()) {
            Provider provider = (Provider) optProvider.get();
            model.addAttribute("provider", provider);
            return "medical/providers/view";
        } else {
            return "redirect:../";
        }
    }
}
