package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.Contact;
import com.dlniemann.digitalpersonalorganizer.models.data.ContactRepository;
import com.dlniemann.digitalpersonalorganizer.models.data.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

//does add/edit/delete go in this controller or the admincontroller?

@Controller
@RequestMapping("contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "All Contacts");
        model.addAttribute("contacts", contactRepository.findAll());
        return "contacts/index";
    }

    @GetMapping("add")
    public String displayAddContactForm(Model model) {
        model.addAttribute("title", "Add Contact");
        model.addAttribute("contact", new Contact());
        model.addAttribute("firstName", contactRepository.findAll());
        model.addAttribute("lastName", contactRepository.findAll());
        model.addAttribute("relationship", contactRepository.findAll());
        model.addAttribute("phoneNumber", contactRepository.findAll());
        model.addAttribute("email", contactRepository.findAll());
        return "contacts/add";
    }

    @PostMapping("add")
    public String processAddContactForm(@ModelAttribute @Valid Contact newContact, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Contact");
            return "contacts/add";
        }
        contactRepository.save(newContact);
        return "redirect:";
    }
    @GetMapping("view/{contactId}")
    public String displayViewContact(Model model, @PathVariable int contactId) {

        Optional optContact = contactRepository.findById(contactId);
        if (optContact.isPresent()) {
            Contact contact = (Contact) optContact.get();
            model.addAttribute("contact", contact);
            return "contacts/view";
        } else {
            return "redirect:../";

        }
    }
}
