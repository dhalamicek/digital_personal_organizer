package com.dlniemann.digitalpersonalorganizer.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Relationship extends AbstractEntity{

    @ManyToMany(mappedBy = "relationships")
   private List<Contact> contacts = new ArrayList<>();

    @ManyToMany(mappedBy = "relationships")
    private List<User> users = new ArrayList<>();

    @NotBlank
    @Size(min = 3, message = "Name must contain a minimum of 3 characters.")
    private String relationshipName;

    public Relationship(){};

    public Relationship (String relationshipName) {

        super();
        this.relationshipName = relationshipName;
    }

    public String getRelationshipName() {
        return relationshipName;
    }

    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<User> getUsers() {
        return users;
    }
}
