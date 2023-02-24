package com.dlniemann.digitalpersonalorganizer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Medication extends AbstractEntity {

    @ManyToOne
    private Provider provider;

    @NotBlank
    @Size(min = 3, message = "Medication name must have at least three characters")
    private String medicationName;


    private String medicationStrengthConcentration;

    private String medicationDose;

    @NotBlank
    @Size(min = 3, message = "Medication frequency must have at least three characters")
    private String medicationFrequency;

    private String medicationPrescriber;

    private String pharmacyWhereMedicationFilled;

    public Medication(String medicationName, String medicationStrengthConcentration, String medicationDose, String medicationFrequency, String medicationPrescriber, String pharmacyWhereMedicationFilled) {
        this.medicationName = medicationName;
        this.medicationStrengthConcentration = medicationStrengthConcentration;
        this.medicationDose = medicationDose;
        this.medicationFrequency = medicationFrequency;
        this.medicationPrescriber = medicationPrescriber;
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

    public String getMedicationPrescriber() {
        return medicationPrescriber;
    }

    public void setMedicationPrescriber(String medicationPrescriber) {
        this.medicationPrescriber = medicationPrescriber;
    }

    public String getPharmacyWhereMedicationFilled() {
        return pharmacyWhereMedicationFilled;
    }

    public void setPharmacyWhereMedicationFilled(String pharmacyWhereMedicationFilled) {
        this.pharmacyWhereMedicationFilled = pharmacyWhereMedicationFilled;
    }
}
