package com.dlniemann.digitalpersonalorganizer.models.dto;

import com.dlniemann.digitalpersonalorganizer.models.Medication;
import com.dlniemann.digitalpersonalorganizer.models.Patient;

import javax.validation.constraints.NotNull;

public class PatientMedicationDTO {

    @NotNull
    private Patient patient;

    @NotNull
    private Medication medication;

    public PatientMedicationDTO(){}

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

}
