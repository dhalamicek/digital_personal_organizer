package com.dlniemann.digitalpersonalorganizer.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity {
    @NotNull
    private String username;
    @NotNull
    private String pwHash;

    @NotNull
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String relationship;

    @NotNull
    private String role;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {
    }
    public User(String username, String password){
        //String email, String} firstName, String lastName, String phoneNumber, String relationship, String role) {
        super();
        //this.firstName = firstName;
        //this.lastName = lastName;
        //this.relationship = relationship;
        //this.phoneNumber = phoneNumber;
        //this.email = email;
        this.username = username;
        this.pwHash = encoder.encode(password);
    }



    public String getUsername() {
        return username;
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



    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}