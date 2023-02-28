package com.dlniemann.digitalpersonalorganizer.models.dto;

import com.dlniemann.digitalpersonalorganizer.models.Medication;
import com.dlniemann.digitalpersonalorganizer.models.Provider;

import javax.validation.constraints.NotNull;

public class ProviderMedicationDTO {

    @NotNull
    private Provider provider;

    @NotNull
    private Medication medication;

    public ProviderMedicationDTO(){}

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }
}
