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
public class Patient extends AbstractEntity {

    @ManyToMany
    @JoinColumn(name = "patient_id")
    private List<User> users = new ArrayList<>();

    @ManyToMany
    @JoinColumn(name = "patient_id")
    private List<Contact> contacts = new ArrayList<>();

    @ManyToMany
    @JoinColumn(name = "patient_id")
    private List<Medication> medications = new ArrayList<>();

    @ManyToMany
    @JoinColumn(name = "patient_id")
    private List<Provider> providers = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "patient_id")
    private final List<File> files = new ArrayList<>();

    @NotBlank
    @Size(min = 2, message = "First Name must contain at least 2 characters")
    private String patientFirstName;

    @NotBlank
    @Size(min = 2, message = "Last Name must contain at least 2 characters")
    private String patientLastName;

    @NotBlank
    @Size(min = 8, message = "Date of Birth must contain at least 8 numbers in MMDDYYYY format")
    private String dOB;

    public Patient(String patientFirstName, String patientLastName, String dOB, List<Contact> contacts, List<Medication> medications, List<Provider> providers, List<User> users){
        super();
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.dOB = dOB;
        this.contacts = contacts;
        this.medications = medications;
        this.providers = providers;
        this.users = users;
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


    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getDOB() {
        return dOB;
    }

    public void setDOB(String dOB) {
        this.dOB = dOB;
    }
}
