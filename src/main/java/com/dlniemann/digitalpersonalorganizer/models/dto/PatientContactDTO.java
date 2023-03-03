package com.dlniemann.digitalpersonalorganizer.models.dto;

import com.dlniemann.digitalpersonalorganizer.models.Contact;
import com.dlniemann.digitalpersonalorganizer.models.Patient;

import javax.validation.constraints.NotNull;

public class PatientContactDTO {

    @NotNull
    private Patient patient;

    @NotNull
    private Contact contact;

    public PatientContactDTO(){}

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
