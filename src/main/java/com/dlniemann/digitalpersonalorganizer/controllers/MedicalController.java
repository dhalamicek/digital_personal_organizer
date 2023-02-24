package com.dlniemann.digitalpersonalorganizer.controllers;


import com.dlniemann.digitalpersonalorganizer.models.data.MedicationsRepository;
import com.dlniemann.digitalpersonalorganizer.models.data.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

//does add/edit/delete go in this controller or the admincontroller?
//how to get two tables on the same page - provider names within medications table and expanded provider table?
@Controller
@RequestMapping(value = "medical")
public class MedicalController {

    @Autowired
    private MedicationsRepository medicationsRepository;

    @Autowired
    private ProvidersRepository providersRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public MedicalController() {

        columnChoices.put("all", "All");
        columnChoices.put("medication", "Medication");
        columnChoices.put("provider", "Provider");
    }

    @RequestMapping("/medications")
    public String listMedications(Model model) {
        model.addAttribute("medications", medicationsRepository.findAll());
        model.addAttribute("providers", providersRepository.findAll());

        return "/list";
    }

    @RequestMapping("/providers")
    public String listProviders(Model model) {
        model.addAttribute("providers", providersRepository.findAll());
        return "/list";
    }
}


