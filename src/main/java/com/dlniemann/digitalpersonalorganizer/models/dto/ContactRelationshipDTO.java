package com.dlniemann.digitalpersonalorganizer.models.dto;

import com.dlniemann.digitalpersonalorganizer.models.Contact;
import org.aspectj.asm.internal.Relationship;

import javax.validation.constraints.NotNull;

public class ContactRelationshipDTO {

    @NotNull
    private Relationship relationship;

    @NotNull
    private Contact contact;

    public ContactRelationshipDTO(){}

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
