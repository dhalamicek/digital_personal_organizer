package com.dlniemann.digitalpersonalorganizer.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    @ManyToMany
    private List<Patient> patients;

   @NotBlank
   @Size(min = 5, message = "Username must have at least 5 characters")
    private String username;

   @NotBlank
   @Size(min = 7, message = "Password must have at least 7 characters")
    private String pwHash;



    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public User(String username, String password){
        super();
        this.username = username;
        this.pwHash = encoder.encode(password);

    }
    public User() {
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {this.username = username;}


    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public String getPwHash() {
        return pwHash;
    }

    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
    }

    public List<Patient> getPatients(){return this.patients;}

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    }

   // public String getEmail() {return email;    }

   // public void setEmail(String email) {
       // this.email = email;    }

    //public String getFirstName() {
        //return firstName;    }

    //public void setFirstName(String firstName) {
        //this.firstName = firstName;    }

    //public String getLastName() {
       // return lastName;    }

    //public void setLastName(String lastName) {
        //this.lastName = lastName;    }

    //public String getPhoneNumber() {
       // return phoneNumber;    }

   // public void setPhoneNumber(String phoneNumber) {
        //this.phoneNumber = phoneNumber;    }

    //public String getRelationship() {
       // return relationship;    }

    //public void setRelationship(String relationship) {
        //this.relationship = relationship;    }

   // public String getRole() {
    // return role;}

    //public void setRole(String role) {
        //this.role = role;    }



