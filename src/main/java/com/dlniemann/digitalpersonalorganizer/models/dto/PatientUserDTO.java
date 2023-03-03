package com.dlniemann.digitalpersonalorganizer.models.dto;

import com.dlniemann.digitalpersonalorganizer.models.Patient;
import com.dlniemann.digitalpersonalorganizer.models.User;

import javax.validation.constraints.NotNull;

public class PatientUserDTO {

    @NotNull
    private Patient patient;

    @NotNull
    private User user;

    public PatientUserDTO(){}

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
