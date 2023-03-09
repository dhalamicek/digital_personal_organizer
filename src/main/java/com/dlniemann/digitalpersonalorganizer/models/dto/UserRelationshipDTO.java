package com.dlniemann.digitalpersonalorganizer.models.dto;

import com.dlniemann.digitalpersonalorganizer.models.Relationship;
import com.dlniemann.digitalpersonalorganizer.models.User;

import javax.validation.constraints.NotNull;

public class UserRelationshipDTO {

    @NotNull
    private User user;

    @NotNull
    private Relationship relationship;

    public UserRelationshipDTO(){};

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }
}
