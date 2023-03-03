package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.Patient;
import com.dlniemann.digitalpersonalorganizer.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


//need to code so that the emergency files and emergency contacts are pulled into the home page, along with the
//insurance card image and headshot image

@Controller
@RequestMapping("")
public class HomePageController {

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

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Basic Patient Information");
        model.addAttribute("firstName", patientRepository.findAll());
        model.addAttribute("lastName", patientRepository.findAll());
        model.addAttribute("dOB", patientRepository.findAll());
        model.addAttribute("contacts", patientRepository.findAll());
        model.addAttribute("medications", patientRepository.findAll());
        model.addAttribute("providers", patientRepository.findAll());
        model.addAttribute("files", patientRepository.findAll());
        return "index";
    }



    @GetMapping("view/{patientId}")
    public String displayViewPatient(Model model, @PathVariable int patientId) {


        Optional optPatient = patientRepository.findById(patientId);
        if (optPatient.isPresent()) {
            Patient patient = (Patient) optPatient.get();
            model.addAttribute("patient", patient);
            return "view";
        } else {
            return "redirect:../";

        }
    }



    }
