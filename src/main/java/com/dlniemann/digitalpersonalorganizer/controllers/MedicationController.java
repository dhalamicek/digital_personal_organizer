package com.dlniemann.digitalpersonalorganizer.controllers;


import com.dlniemann.digitalpersonalorganizer.models.Medication;
import com.dlniemann.digitalpersonalorganizer.models.data.MedicationsRepository;
import com.dlniemann.digitalpersonalorganizer.models.data.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

//does add/edit/delete go in this controller or the admincontroller?
//how to pull in provider name from providers for prescriber
@Controller
@RequestMapping("medical/medications")
public class MedicationController {

    @Autowired
    private MedicationsRepository medicationsRepository;

    @Autowired
    private ProvidersRepository providersRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("medications", medicationsRepository.findAll());
        return "medical/medications/index";
    }

    @GetMapping("view/{medicationId}")
    public String displayViewMedication(Model model, @PathVariable int medicationId) {

        Optional optMedication = medicationsRepository.findById(medicationId);
        if (optMedication.isPresent()) {
            Medication medication = (Medication) optMedication.get();
            model.addAttribute("medication", medication);
            return "medical/medications/view";
        } else {
            return "redirect:../";

        }
    }
}

