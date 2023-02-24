package com.dlniemann.digitalpersonalorganizer.models;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Provider extends AbstractEntity{

    @OneToMany
    @JoinColumn(name = "provider_id")
    private final List<Medication> medications = new ArrayList<>();

    @NotBlank
    @Size(min = 3, message = "Provider Role must contain at least three characters")
    private String providerRole;

    @NotBlank
    @Size(min = 3, message = "Provider Name must contain at least three characters")
    private String providerName;

    @NotBlank
    @Size(min = 10, max = 11, message = "Provider Phone Number must contain at least 10 numbers and no more than 11 numbers (no letters or symbols)")
    private Integer providerPhoneNumber;

    public Provider(String providerRole, String providerName, Integer providerPhoneNumber) {

        this.providerRole = providerRole;
        this.providerName = providerName;
        this.providerPhoneNumber = providerPhoneNumber;
    }

    public Provider() {}

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
        return medications;
    }
}

