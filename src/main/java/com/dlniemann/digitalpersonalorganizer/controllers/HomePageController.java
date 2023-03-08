package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.Patient;
import com.dlniemann.digitalpersonalorganizer.models.data.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    //this is the page after user successful login. home page should have function to choose the patient desired from an index of patients the user is
    // linked to and then when clicked, be redirected to the patient's home page, which has their basic info, emergency contacts, and
    //links to their other pages (contacts/files/providers/meds) in cards
    //
    //
    //how do I limit the patient list just to the patients this user has access to?
    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "All Patients");
        model.addAttribute("patients", patientRepository.findAll());
       return "index";
    }

    @RequestMapping("view/{patientId}")
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
