package com.dlniemann.digitalpersonalorganizer.models;



import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact extends PersonEntity {

    @ManyToMany
    private List<Patient> patients = new ArrayList<>();

    @ManyToMany
    private List<Relationship> relationships = new ArrayList<>();

    @NotBlank
    private Boolean emergencyContact;

    public Contact(List<Relationship> relationships, Boolean emergencyContact) {
        super();

        this.relationships = relationships;
        this.emergencyContact = emergencyContact;
    }

    public Contact() {
    }


    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public Boolean getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(Boolean emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
