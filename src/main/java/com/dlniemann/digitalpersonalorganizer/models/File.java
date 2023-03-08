package com.dlniemann.digitalpersonalorganizer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class File extends AbstractEntity {
    @ManyToOne
   private Patient patient;

    @NotNull
    @GeneratedValue
    @Id
    private String fileId;
    private String fileName;

    private String fileDescription;

    @Lob
    private byte[] file;

    public File() {

    }

    public File(Patient patient, String fileId, String fileName, String fileDescription, byte[] file) {
        this.patient = patient;
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.file = file;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] data) {
        this.file = file;
    }

    public Patient getPatient() {return this.patient;}


}


