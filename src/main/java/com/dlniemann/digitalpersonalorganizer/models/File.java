package com.dlniemann.digitalpersonalorganizer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Entity
public class File extends AbstractEntity {

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

    public File(String fileId, String fileName, String fileType, byte[] data) {
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
}