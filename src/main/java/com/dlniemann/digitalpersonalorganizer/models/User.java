package com.dlniemann.digitalpersonalorganizer.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends PersonEntity {

    @ManyToMany
    private List<Patient> patients = new ArrayList<>();

    @ManyToMany
    private List<Relationship> relationships = new ArrayList<>();





   @NotBlank
   @Size(min = 5, message = "Username must have at least 5 characters")
    private String username;

   @NotBlank
   @Size(min = 7, message = "Password must have at least 7 characters")
    private String pwHash;



    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public User(String username, String password, List<Relationship> relationships, List<Patient> patients){
        super();
        this.relationships = relationships;
        this.patients = patients;
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

    public List<Relationship> getRelationships() {
        return this.relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }
    }


   // public String getRole() {
    // return role;}

    //public void setRole(String role) {
        //this.role = role;    }



