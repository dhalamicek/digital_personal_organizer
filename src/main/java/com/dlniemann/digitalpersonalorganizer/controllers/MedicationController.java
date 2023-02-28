package com.dlniemann.digitalpersonalorganizer.controllers;


import com.dlniemann.digitalpersonalorganizer.models.Medication;
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
@RequestMapping("medications")
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
        return "medications/index";
    }

    @GetMapping("add")
    public String displayAddMedicationForm(Model model) {
        model.addAttribute("title", "Add Medication");
        model.addAttribute("medication", new Medication());
        model.addAttribute("medicationName", medicationsRepository.findAll());
        model.addAttribute("medicationStrengthConcentration", medicationsRepository.findAll());
        model.addAttribute("medicationDose", medicationsRepository.findAll());
        model.addAttribute("medicationFrequency", medicationsRepository.findAll());
        model.addAttribute("provider", providersRepository.findAll());
        model.addAttribute("pharmacyWhereMedicationFilled", medicationsRepository.findAll());
        return "medications/add";
    }

    @PostMapping("add")
    public String processAddMedicationForm(@ModelAttribute @Valid Medication newMedication, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Medication");
            return "medications/add";
        }
        medicationsRepository.save(newMedication);
        return "redirect:";
    }

    @GetMapping("view/{medicationId}")
    public String displayViewMedication(Model model, @PathVariable int medicationId) {

        Optional optMedication = medicationsRepository.findById(medicationId);
        if (optMedication.isPresent()) {
            Medication medication = (Medication) optMedication.get();
            model.addAttribute("medication", medication);
            return "medications/view";
        } else {
            return "redirect:../";

        }
    }
}

