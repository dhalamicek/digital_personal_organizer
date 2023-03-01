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

    public User() {
    }
    public User(String username, String password) {
        super();
        this.username = username;
        this.pwHash = encoder.encode(password);
    }
    public String getUsername() {
        return username;
    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}