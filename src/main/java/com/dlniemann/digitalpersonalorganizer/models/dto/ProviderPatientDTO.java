package com.dlniemann.digitalpersonalorganizer.models.dto;

import com.dlniemann.digitalpersonalorganizer.models.Patient;
import com.dlniemann.digitalpersonalorganizer.models.Provider;

import javax.validation.constraints.NotNull;

public class ProviderPatientDTO {

    @NotNull
    private Provider provider;

    @NotNull
    private Patient patient;

    public ProviderPatientDTO(){}

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
