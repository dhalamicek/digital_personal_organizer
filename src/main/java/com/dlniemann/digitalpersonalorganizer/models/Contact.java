package com.dlniemann.digitalpersonalorganizer.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact extends AbstractEntity {

    @ManyToMany(mappedBy = "contacts")
    private List<Patient> patients = new ArrayList<>();

    @NotBlank
    @Size(min = 2, message = "First Name must be at least two characters")
    private String firstName;

    @NotBlank
    @Size(min = 2, message = "Last Name must be at least two characters")
    private String lastName;

    @NotBlank
    @Size(min = 3, message = "Relationship must be at least three characters")
    private String relationship;

    @NotBlank
    @Size(min = 10, max = 11, message = "Phone number must be at least 10 numbers and maximum 11")
    private Integer phoneNumber;


   @Email
    private String email;

   //need to figure out how to make Emergency Contact limited to only yes or no
   //@NotBlank
    //private Boolean emergencyContact;

    public Contact (String firstName, String lastName, String relationship, Integer phoneNumber, String email){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.relationship = relationship;
        this.phoneNumber = phoneNumber;
        this.email = email;
        //this.emergencyContact = emergencyContact;
    }
    public Contact (){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Patient> getPatients(){
        return patients;
    }

    //public String getEmergencyContact() {
        //return emergencyContact;
    //}

    //public void setEmergencyContact(String emergencyContact) {
        //this.emergencyContact = emergencyContact;
    //}
}
