package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.data.FileRepository;
import com.dlniemann.digitalpersonalorganizer.models.data.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@RequestMapping("view/{patientId}/files")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private PatientRepository patientRepository;
    private ResultSet result;
    private PreparedStatement statement;


    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("files", fileRepository.findAll());
        return "files/index";
    }

    @GetMapping("/downloadServlet")
    public String displayViewFile(Model model, @PathVariable String fileId) throws SQLException {

        result = statement.executeQuery();

        if (result.next()) {
            Blob blob = result.getBlob("file");
            InputStream inputStream = blob.getBinaryStream();
            return "view/{patientId}/files";
        } else {
            return "redirect:../";
        }
    }




}

