package com.dlniemann.digitalpersonalorganizer.models;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Provider extends AbstractEntity{

    @ManyToOne
    private Patient patient;

    @ManyToMany
    private List<Medication> medications;

    @NotBlank(message = "Provider Role is required")
    @Size(min = 3, message = "Provider Role must contain at least three characters")
    private String providerRole;

    @NotBlank (message = "Provider Name is required")
    @Size(min = 3, message = "Provider Name must contain at least three characters")
    private String providerName;

    @NotBlank (message = "Provider Phone Number is required")
    @Size(min = 10, max = 11, message = "Provider Phone Number must contain at least 10 numbers and no more than 11 numbers (no letters or symbols)")
    private Integer providerPhoneNumber;

    public Provider() {}
    public Provider(String providerRole, String providerName, Integer providerPhoneNumber, Patient patient, List<Medication> medications) {
        super();
        this.providerRole = providerRole;
        this.providerName = providerName;
        this.providerPhoneNumber = providerPhoneNumber;
        this.patient = patient;
        this.medications = medications;
    }



    public String getProviderRole() {
        return providerRole;
    }

    public void setProviderRole(String providerRole) {
        this.providerRole = providerRole;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Integer getProviderPhoneNumber() {
        return providerPhoneNumber;
    }

    public void setProviderPhoneNumber(Integer providerPhoneNumber) {
        this.providerPhoneNumber = providerPhoneNumber;
    }

    public List<Medication> getMedications() {
        return this.medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


}

