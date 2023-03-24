package com.dlniemann.digitalpersonalorganizer.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


//how to make medicationPrescriber pull names from provider
@Entity
public class Medication extends AbstractEntity {



    @NotBlank(message = "Medication name is required")
    @Size(min = 3, max = 50, message = "Medication name must be between 3 and 50 characters")
    private String medicationName;


    private String medicationStrengthConcentration;

    private String medicationDose;

    @NotBlank(message = "Frequency is required")
    @Size(min = 3, message = "Medication frequency must have at least three characters")
    private String medicationFrequency;

     @ManyToMany
     private List<Patient> patients = new ArrayList<>();

    @ManyToMany(mappedBy = "medications")
    private List<Provider> providers = new ArrayList<>();




    public Medication(String medicationName, String medicationStrengthConcentration, String medicationDose, String medicationFrequency, List<Provider> providers) {
        super();
        this.medicationName = medicationName;
        this.medicationStrengthConcentration = medicationStrengthConcentration;
        this.medicationDose = medicationDose;
        this.medicationFrequency = medicationFrequency;
        this.providers = providers;


    }

    public Medication(){}

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getMedicationStrengthConcentration() {
        return medicationStrengthConcentration;
    }

    public void setMedicationStrengthConcentration(String medicationStrengthConcentration) {
        this.medicationStrengthConcentration = medicationStrengthConcentration;
    }

    public String getMedicationDose() {
        return medicationDose;
    }

    public void setMedicationDose(String medicationDose) {
        this.medicationDose = medicationDose;
    }

    public String getMedicationFrequency() {
        return medicationFrequency;
    }

    public void setMedicationFrequency(String medicationFrequency) {
        this.medicationFrequency = medicationFrequency;
    }

    public List<Provider> getProviders(){return this.providers;}

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }
    public List<Patient> getPatients(){return this.patients;}

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
