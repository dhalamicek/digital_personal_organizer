package com.dlniemann.digitalpersonalorganizer.models;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Provider extends PersonEntity{

    @ManyToMany(mappedBy = "providers")
    private List<Patient> patients;

    @ManyToMany(mappedBy = "providers")
    private List<Medication> medications;

    @NotBlank(message = "Provider Role is required")
    @Size(min = 3, message = "Provider Role must contain at least three characters")
    private String providerRole;


    public Provider() {}
    public Provider(String providerRole, List<Medication> medications, List<Patient> patients) {
        super();
        this.providerRole = providerRole;
        this.medications = medications;
        this.patients = patients;
    }



    public String getProviderRole() {
        return providerRole;
    }

    public void setProviderRole(String providerRole) {
        this.providerRole = providerRole;
    }


    public List<Medication> getMedications() {
        return this.medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public List<Patient> getPatients(){return this.patients;}

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }


}

