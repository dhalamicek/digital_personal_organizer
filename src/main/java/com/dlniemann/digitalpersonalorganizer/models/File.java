package com.dlniemann.digitalpersonalorganizer.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class File extends AbstractEntity {

    @NotBlank
    private String fileName;

    //@NotBlank
    //private String fileType;

    private String description;

    @DateTimeFormat
    private Date uploadDate;

    @Size(min = 2, max = 3, message = "Emergency Document must be either yes or no")
    private String emergencyDocument;

    @Size(min = 2, max = 3, message = "Use for headshot must be either yes or no")
    private String headShot;

    @Size(min = 2, max = 3, message = "Image of Insurance Card must be either yes or no")
    private String insCard;

    @Lob
    private byte[] data;

    public File(String fileName, String description, Date uploadDate, String emergencyDocument, String headShot, String insCard, byte[] data) {
        super();
        this.fileName = fileName;
        this.description = description;
        this.uploadDate = uploadDate;
        this.emergencyDocument = emergencyDocument;
        this.headShot = headShot;
        this.insCard = insCard;
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getEmergencyDocument() {
        return emergencyDocument;
    }

    public void setEmergencyDocument(String emergencyDocument) {
        this.emergencyDocument = emergencyDocument;
    }

    public String getHeadShot() {
        return headShot;
    }

    public void setHeadShot(String headShot) {
        this.headShot = headShot;
    }

    public String getInsCard() {
        return insCard;
    }

    public void setInsCard(String insCard) {
        this.insCard = insCard;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
