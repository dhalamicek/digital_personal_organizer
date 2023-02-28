package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.*;
import com.dlniemann.digitalpersonalorganizer.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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

    @GetMapping("add")
    public String displayAddPatientForm(Model model) {
        model.addAttribute("title", "Add Patient");
        model.addAttribute(new Patient());
        model.addAttribute("contacts", contactRepository.findAll());
        model.addAttribute("medications", medicationsRepository.findAll());
        model.addAttribute("providers", providersRepository.findAll());
        model.addAttribute("files", fileRepository.findAll());
        return "add";
    }

        @PostMapping("add")
        public String processAddPatientForm(@ModelAttribute @Valid Patient newPatient, Errors errors, Model model, @RequestParam List<Integer> contacts, @RequestParam List<Integer> medications, @RequestParam List<Integer> providers, @RequestParam List<String> files) {
            if (errors.hasErrors()) {
                model.addAttribute("title", "Add Patient");

                return "patients/add";
            }
            List<Contact> contactObjs = (List<Contact>) contactRepository.findAllById(contacts);
            newPatient.setContacts(contactObjs);
            List<Medication> medicationObjs = (List<Medication>) medicationsRepository.findAllById(medications);
            newPatient.setMedications(medicationObjs);
            List<Provider> providerObjs = (List<Provider>) providersRepository.findAllById(providers);
            newPatient.setProviders(providerObjs);
            List<DBFile> fileObjs = (List<DBFile>) fileRepository.findAllById(files);
            newPatient.setFiles(fileObjs);

            patientRepository.save(newPatient);

            return "redirect:";
        }

    @GetMapping("view/{jobId}")
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
