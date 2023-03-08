package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//need header with Home (is for the entire list of patients), Patient Home, Contacts, Files, Medications, Providers
//need patient name included in header of every page
//need search feature on every page

//this is the patient's home page, which has their basic info, emergency contacts, and
// links to their other pages (contacts/files/providers/meds) in cards

@Controller
@RequestMapping("/view/{patientId}")
public class SinglePatientLandingPageController {


    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private MedicationsRepository medicationsRepository;
    @Autowired
    private ProvidersRepository providersRepository;
    @Autowired
    private FileRepository fileRepository;


    @GetMapping("")
    public String indexOfPatientInfo(Model model, @PathVariable int patientId) {
        model.addAttribute("title", "Patient Information");
        model.addAttribute("firstName", patientRepository.findById(patientId));
        model.addAttribute("lastName", patientRepository.findById(patientId));
        model.addAttribute("dOB", patientRepository.findById(patientId));
        model.addAttribute("title", "Contacts");
        model.addAttribute("title", "Files");
        model.addAttribute("title", "Medications");
        model.addAttribute("title", "Providers");

        return "/view/{patientId}index";
    }

   }
