package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.Relationship;
import com.dlniemann.digitalpersonalorganizer.models.data.ContactRepository;
import com.dlniemann.digitalpersonalorganizer.models.data.RelationshipRepository;
import com.dlniemann.digitalpersonalorganizer.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("relationships")
public class RelationshipController {

    @Autowired
    private RelationshipRepository relationshipRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("relationships", relationshipRepository.findAll());
        return "relationships/index";
    }

    @GetMapping("view/{relationshipId")
    public String displayViewRelationship(Model model, @PathVariable int relationshipId){
        Optional optRelationship = relationshipRepository.findById(relationshipId);
        if (optRelationship.isPresent()) {
            Relationship relationship = (Relationship) optRelationship.get();
            model.addAttribute("relationship", relationship);
            return "relationships/view";
        } else {
            return "redirect:../";

        }
    }
}
