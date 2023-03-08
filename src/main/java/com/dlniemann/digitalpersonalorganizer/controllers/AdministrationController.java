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

@Controller
@RequestMapping("admin")
public class AdministrationController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private MedicationsRepository medicationsRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ProvidersRepository providersRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Contacts");
        model.addAttribute("title", "Files");
        model.addAttribute("title", "Medications");
        model.addAttribute("title", "Patients");
        model.addAttribute("title", "Providers");
        model.addAttribute("title", "Users");
        return "index";
    }

    @GetMapping("contacts/add")
    public String displayAddContactForm(Model model) {
        model.addAttribute("title", "Add Contact");
        model.addAttribute("contact", new Contact());
        model.addAttribute("firstName", contactRepository.findAll());
        model.addAttribute("lastName", contactRepository.findAll());
        model.addAttribute("relationship", contactRepository.findAll());
        model.addAttribute("phoneNumber", contactRepository.findAll());
        model.addAttribute("email", contactRepository.findAll());
        model.addAttribute("emergency", contactRepository.findAll());
        return "contacts/add";
    }

    @PostMapping("contacts/add")
    public String processAddContactForm(@ModelAttribute @Valid Contact newContact, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Contact");
            return "contacts/add";
        }
        contactRepository.save(newContact);
        return "redirect:";
    }

    @GetMapping("files/upload")
    public String displayUploadFileForm(Model model) {
        model.addAttribute("title", "Upload File");
        model.addAttribute("file", new File());
        model.addAttribute("fileId", fileRepository.findAll());
        model.addAttribute("fileName", fileRepository.findAll());
        model.addAttribute("fileDescription", fileRepository.findAll());
        model.addAttribute("file", fileRepository.findAll());
        return "files/upload/uploadServlet";
    }


    //how do I set up the post mapping for the upload?





    @GetMapping("medications/add")
    public String displayAddMedicationsForm(Model model) {
        model.addAttribute("title", "Add Medication");
        model.addAttribute(new Medication());
        model.addAttribute("medicationName", medicationsRepository.findAll());
        model.addAttribute("medicationStrengthConcentration", medicationsRepository.findAll());
        model.addAttribute("medicationDose", medicationsRepository.findAll());
        model.addAttribute("medicationFrequency", medicationsRepository.findAll());
        model.addAttribute("provider", medicationsRepository.findAll());
        return "medications/add";
    }

    @PostMapping("medications/add")
    public String processAddMedicationForm(@ModelAttribute @Valid Medication newMedication, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Medication");

            return "medications/add";
        }
        medicationsRepository.save(newMedication);
        return "redirect:";
    }


    @GetMapping("patients/add")
    public String displayAddPatientForm(Model model) {
        model.addAttribute("title", "Add Patient");
        model.addAttribute(new Patient());
        return "patients/add";
    }

    //where do I connect user(s) to a patient?

    @PostMapping("patients/add")
    public String processAddPatientForm(@ModelAttribute @Valid Patient newPatient, Errors errors, Model
            model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Patient");

            return "patients/add";
        }

        patientRepository.save(newPatient);
        return "redirect:";
    }


    @GetMapping("providers/add")
    public String displayAddProviderForm(Model model) {
        model.addAttribute("title", "Add Provider");
        model.addAttribute("provider", new Provider());
        model.addAttribute("providerRole", providersRepository.findAll());
        model.addAttribute("providerName", providersRepository.findAll());
        model.addAttribute("providerPhoneNumber", providersRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());

        return "providers/add";
    }

    @PostMapping("providers/add")
    public String processAddProviderForm(@ModelAttribute @Valid Provider newProvider, Errors errors, Model
            model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Provider");
            return "providers/add";
        }
        providersRepository.save(newProvider);
        return "redirect:";
    }


    @GetMapping("users/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute("user", new User());
        model.addAttribute("firstName", userRepository.findAll());
        model.addAttribute("lastName", userRepository.findAll());
        model.addAttribute("relationship", userRepository.findAll());
        model.addAttribute("phoneNumber", userRepository.findAll());
        model.addAttribute("email", userRepository.findAll());
        model.addAttribute("username", userRepository.findAll());
        model.addAttribute("password", userRepository.findAll());

        return "users/add";
    }

    @PostMapping("users/add")
    public String processAddUserForm(@ModelAttribute @Valid User newUser, Errors errors, Model
            model, @RequestParam List<Integer> users) {

            if (errors.hasErrors()) {
                model.addAttribute("title", "Add User");

                return "users/add";
            }

            userRepository.save(newUser);
            return "redirect:";
    }
}


