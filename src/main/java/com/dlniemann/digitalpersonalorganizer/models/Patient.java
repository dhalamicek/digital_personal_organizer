package com.dlniemann.digitalpersonalorganizer.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient extends PersonEntity {

    @ManyToMany(mappedBy = "patients")
    private List<User> users = new ArrayList<>();

    @ManyToMany(mappedBy = "patients")
    private List<Contact> contacts = new ArrayList<>();

    @ManyToMany(mappedBy = "patients")
    private List<Medication> medications = new ArrayList<>();

    @ManyToMany(mappedBy = "patients")
    private List<Provider> providers = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "patient_id")
    private List<File> files = new ArrayList<>();



    @NotBlank
    @Size(min = 8, message = "Date of Birth must contain at least 8 numbers in MMDDYYYY format")
    private String dOB;

    public Patient(String dOB, List<Contact> contacts, List<Medication> medications, List<Provider> providers, List<User> users, List<File> files){
        super();
        this.dOB = dOB;
        this.contacts = contacts;
        this.medications = medications;
        this.providers = providers;
        this.users = users;
        this.files = files;
    }

    public Patient(){}




    public List<Contact> getContacts() {
        return contacts;
    }


    public List<Medication> getMedications() {
        return medications;
    }


    public List<Provider> getProviders() {
        return providers;
    }


    public List<File> getFiles() {
        return files;
    }

    public List<User> getUsers() {return users;}


    public String getDOB() {
        return dOB;
    }

    public void setDOB(String dOB) {
        this.dOB = dOB;
    }
}
