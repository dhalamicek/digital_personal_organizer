package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.Contact;
import com.dlniemann.digitalpersonalorganizer.models.data.ContactRepository;
import com.dlniemann.digitalpersonalorganizer.models.data.PatientRepository;
import com.dlniemann.digitalpersonalorganizer.models.data.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


//should lists be in the listcontroller or in the controller of the content?

@Controller
@RequestMapping("view/{patientId}/contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RelationshipRepository relationshipRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "All Contacts");
        model.addAttribute("contacts", contactRepository.findAll());
        return "/index";
    }


    @GetMapping("/{contactId}")
    public String displayViewContact(Model model, @PathVariable int contactId) {

        Optional optContact = contactRepository.findById(contactId);
        if (optContact.isPresent()) {
            Contact contact = (Contact) optContact.get();
            model.addAttribute("contact", contact);
            return "view/{patientId}/contacts";
        } else {
            return "redirect:../";

        }
    }


}
