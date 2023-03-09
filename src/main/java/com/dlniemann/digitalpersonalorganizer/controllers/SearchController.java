package com.dlniemann.digitalpersonalorganizer.controllers;


import com.dlniemann.digitalpersonalorganizer.models.Patient;
import com.dlniemann.digitalpersonalorganizer.models.PatientData;
import com.dlniemann.digitalpersonalorganizer.models.data.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import static com.dlniemann.digitalpersonalorganizer.controllers.ListController.columnChoices;



@Controller
@RequestMapping("view/{patientId}/search")
public class SearchController {

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        Iterable<Patient> patients;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")) {
            patients = patientRepository.findAll();
        } else {
            patients = PatientData.findByColumnAndValue(searchType, searchTerm, patientRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Patients with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("patients", patients);

        return "search";
    }
}
