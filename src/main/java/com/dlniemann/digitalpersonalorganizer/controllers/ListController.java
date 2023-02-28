package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

//this list would be helpful if I had multiple patients, but I want to search within one patient
}
