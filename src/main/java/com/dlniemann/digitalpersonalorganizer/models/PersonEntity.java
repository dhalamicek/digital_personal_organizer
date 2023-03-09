package com.dlniemann.digitalpersonalorganizer.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@MappedSuperclass
public abstract class PersonEntity {

    @Id
    @GeneratedValue
    private int id;



    @NotBlank
    @Size(min = 2, message = "First name must contain a minimum of 2 characters.")
    private String firstName;

    @NotBlank
    @Size(min = 2, message = "Last name must contain a minimum of 2 characters.")
    private String lastName;

    @NotBlank
    @Size(min = 10, max = 11, message = "Phone number must be at least 10 numbers and maximum 11")
    private String phoneNumber;


    @Email
    private String email;

    public int getId(){
        return id;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
