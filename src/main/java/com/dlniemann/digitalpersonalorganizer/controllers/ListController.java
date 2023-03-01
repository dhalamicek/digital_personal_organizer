package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.*;
import com.dlniemann.digitalpersonalorganizer.models.data.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ProvidersRepository providersRepository;

    @Autowired
    private MedicationsRepository medicationsRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private FileRepository fileRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("provider", "Provider");
        columnChoices.put("medication", "Medication");
        columnChoices.put("contact", "Contact");
        columnChoices.put("file", "File");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("providers", providersRepository.findAll());
        model.addAttribute("medications", medicationsRepository.findAll());
        model.addAttribute("contacts", contactRepository.findAll());
        model.addAttribute("files", fileRepository.findAll());
        return "list";
    }

@RequestMapping(value = "patients")
    public String listPatientsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Patient> patients;
        if (column.toLowerCase().equals("all")){
            patients = patientRepository.findAll();
            model.addAttribute("title", "All Patients");
    } else {
            patients = PatientData.findByColumnAndValue(column, value, patientRepository.findAll());
            model.addAttribute("title", "Patients with " + columnChoices.get(column) + ": " + value);
    }
    model.addAttribute("patients", patients);

        return "list-patients";
}
}
