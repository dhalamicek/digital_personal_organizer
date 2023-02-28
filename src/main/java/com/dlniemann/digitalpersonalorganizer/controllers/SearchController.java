package com.dlniemann.digitalpersonalorganizer.controllers;


import com.dlniemann.digitalpersonalorganizer.models.data.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//how do I set up the search when it is one patient and searching many parts of that patient: medications, files, contacts,
//and return the results of just that aspect of the patient?

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("")
    public String search(Model model) {
        //model.addAttribute("columns", columnChoices);
        return "search";
    }

   // @PostMapping("results")
    //public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        //Iterable<Patient> patients;
       // if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
           // patients = patientRepository.findAll();
        } //else {
            //patients = patientRepository.findByColumnAndValue(searchType, searchTerm, patientRepository.findAll());
       // }
        //model.addAttribute("columns", columnChoices);
        //model.addAttribute("title", "Patients with " + columnChoices.get(searchType) + ": " + searchTerm);
        //model.addAttribute("patients", patients);

       // return "search";
    //}

