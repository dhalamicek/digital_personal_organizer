package com.dlniemann.digitalpersonalorganizer.models;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class File extends AbstractEntity {

    @ManyToOne
   private Patient patient;


    private String fileName;

    private String fileDescription;

    @Lob
    private byte[] file;

    public File() {

    }

    public File(Patient patient, String fileId, String fileName, String fileDescription, byte[] file) {
        super();
        this.patient = patient;
        //this.fileId = fileId;
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.file = file;
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


