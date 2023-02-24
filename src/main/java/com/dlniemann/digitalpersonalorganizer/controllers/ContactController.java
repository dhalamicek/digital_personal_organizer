package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.Contact;
import com.dlniemann.digitalpersonalorganizer.models.data.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

//does add/edit/delete go in this controller or the admincontroller?

@Controller
@RequestMapping("contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "contacts/index";
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
