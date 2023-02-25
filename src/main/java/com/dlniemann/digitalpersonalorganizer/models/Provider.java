package com.dlniemann.digitalpersonalorganizer.models;


import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Provider extends AbstractEntity{

    @NotBlank(message = "Provider Role is required")
    @Size(min = 3, message = "Provider Role must contain at least three characters")
    private String providerRole;

    @NotBlank (message = "Provider Name is required")
    @Size(min = 3, message = "Provider Name must contain at least three characters")
    private String providerName;

    @NotBlank (message = "Provider Phone Number is required")
    @Size(min = 10, max = 11, message = "Provider Phone Number must contain at least 10 numbers and no more than 11 numbers (no letters or symbols)")
    private Integer providerPhoneNumber;

    public Provider(String providerRole, String providerName, Integer providerPhoneNumber) {
        super();
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


}

