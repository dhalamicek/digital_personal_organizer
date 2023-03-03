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

    private String fileType;

    @Lob
    private byte[] data;

    public File() {

    }

    public File(Patient patient, String fileId, String fileName, String fileType, byte[] data) {
        this.patient = patient;
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Patient getPatient() {return this.patient;}
}
