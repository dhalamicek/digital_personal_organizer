package com.dlniemann.digitalpersonalorganizer.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


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

    @ManyToOne
    private Provider provider;

    private String pharmacyWhereMedicationFilled;

    public Medication(String medicationName, String medicationStrengthConcentration, String medicationDose, String medicationFrequency, Provider provider, String pharmacyWhereMedicationFilled) {
        super();
        this.medicationName = medicationName;
        this.medicationStrengthConcentration = medicationStrengthConcentration;
        this.medicationDose = medicationDose;
        this.medicationFrequency = medicationFrequency;
        this.provider = provider;
        this.pharmacyWhereMedicationFilled = pharmacyWhereMedicationFilled;
    }

    public Medication(){}

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

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



    public String getPharmacyWhereMedicationFilled() {
        return pharmacyWhereMedicationFilled;
    }

    public void setPharmacyWhereMedicationFilled(String pharmacyWhereMedicationFilled) {
        this.pharmacyWhereMedicationFilled = pharmacyWhereMedicationFilled;
    }
}
