package com.dlniemann.digitalpersonalorganizer.service;


import com.dlniemann.digitalpersonalorganizer.exceptions.FileStorageException;
import com.dlniemann.digitalpersonalorganizer.exceptions.MyFileNotFoundException;
import com.dlniemann.digitalpersonalorganizer.models.DBFile;
import com.dlniemann.digitalpersonalorganizer.models.data.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class DBFileService {

    @Autowired
    private FileRepository fileRepository;

    public DBFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            return fileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DBFile getFile(String id) {
        return fileRepository.findById(id).orElseThrow(() -> new MyFileNotFoundException("File not found with id " + id));
    }
}
