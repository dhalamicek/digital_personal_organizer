package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.File;
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

import java.util.Optional;

@RestController
@RequestMapping("/files")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private PatientRepository patientRepository;



    //how to have an index of file names with links to the document download ?



    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("files", fileRepository.findAll());
        return "files/index";
    }

    @GetMapping("view/{fileId}")
    public String displayViewEmployer(Model model, @PathVariable String fileId) {
        Optional optFile = fileRepository.findById(fileId);
        if (optFile.isPresent()) {
            File file = (File) optFile.get();
            model.addAttribute("file", file);
            return "files/view";
        } else {
            return "redirect:../";
        }
    }




}

