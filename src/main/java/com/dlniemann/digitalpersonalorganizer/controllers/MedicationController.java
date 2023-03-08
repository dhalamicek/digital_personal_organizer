package com.dlniemann.digitalpersonalorganizer.controllers;


import com.dlniemann.digitalpersonalorganizer.models.Medication;
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


@Controller
@RequestMapping("/view/{patientId}/medications")
public class MedicationController {

    @Autowired
    private MedicationsRepository medicationsRepository;

    @Autowired
    private ProvidersRepository providersRepository;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "All Medications");
        model.addAttribute("medications", medicationsRepository.findAll());
        return "/index";
    }



    @GetMapping("/{medicationId}")
    public String displayViewMedication(Model model, @PathVariable int medicationId) {

        Optional optMedication = medicationsRepository.findById(medicationId);
        if (optMedication.isPresent()) {
            Medication medication = (Medication) optMedication.get();
            model.addAttribute("medication", medication);
            return "/view/{patientId}/medications";
        } else {
            return "redirect:../";

        }
    }
}

