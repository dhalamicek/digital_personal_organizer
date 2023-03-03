package com.dlniemann.digitalpersonalorganizer.controllers;

import com.dlniemann.digitalpersonalorganizer.models.*;
import com.dlniemann.digitalpersonalorganizer.models.data.*;
import com.dlniemann.digitalpersonalorganizer.payload.UploadFileResponse;
import com.dlniemann.digitalpersonalorganizer.service.DBFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdministrationController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private DBFileService dbFileService;

    @Autowired
    private MedicationsRepository medicationsRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ProvidersRepository providersRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/admin/contacts")
    public String contactsIndex (Model model) {
            model.addAttribute("title", "All Contacts");
        model.addAttribute("contacts", contactRepository.findAll());
        return "admin/contacts/index";
}

    @GetMapping("/admin/contacts/add")
    public String displayAddContactForm(Model model) {
        model.addAttribute("title", "Add Contact");
        model.addAttribute("contact", new Contact());
        model.addAttribute("firstName", contactRepository.findAll());
        model.addAttribute("lastName", contactRepository.findAll());
        model.addAttribute("relationship", contactRepository.findAll());
        model.addAttribute("phoneNumber", contactRepository.findAll());
        model.addAttribute("email", contactRepository.findAll());
        return "/admin/contacts/add";
    }

    @PostMapping("/admin/contacts/add")
    public String processAddContactForm(@ModelAttribute @Valid Contact newContact, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Contact");
            return "/admin/contacts/add";
        }
        contactRepository.save(newContact);
        return "redirect:";
    }

    @RequestMapping("/admin/files")
    public String contactsFiles(Model model) {
        model.addAttribute("title", "All Files");
        model.addAttribute("files", fileRepository.findAll());
        return "admin/files/index";
    }

    @GetMapping("/admin/files/upload")
    public String displayUploadFileForm(Model model) {
        model.addAttribute("title", "Upload File");
        model.addAttribute("file", new File());
        model.addAttribute("fileId", fileRepository.findAll());
        model.addAttribute("fileName", fileRepository.findAll());
        model.addAttribute("fileType", fileRepository.findAll());
        model.addAttribute("data", fileRepository.findAll());
        return "/admin/files/upload";
    }


    @PostMapping("/admin/files/upload")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        File file = dbFileService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile").path(file.getId()).toUriString();

        return new UploadFileResponse(file.getFileName(), fileDownloadUri, file.getFileType(), file.getData());
    }

    @RequestMapping("/admin/medications")
    public String medicationsIndex (Model model) {
        model.addAttribute("title", "All Medications");
        model.addAttribute("medications", medicationsRepository.findAll());
        return "admin/medications/index";
    }

    @RequestMapping("/admin/patients")
    public String patientsIndex (Model model) {
        model.addAttribute("title", "All Patients");
        model.addAttribute("patients", patientRepository.findAll());
        return "admin/patients/index";
    }

    @GetMapping("admin/patients/add")
    public String displayAddPatientForm(Model model) {
        model.addAttribute("title", "Add Patient");
        model.addAttribute(new Patient());
        model.addAttribute("contacts", contactRepository.findAll());
        model.addAttribute("medications", medicationsRepository.findAll());
        model.addAttribute("providers", providersRepository.findAll());
        model.addAttribute("files", fileRepository.findAll());
        return "admin/patients/add";
    }

    @PostMapping("admin/patients/add")
    public String processAddPatientForm(@ModelAttribute @Valid Patient newPatient, Errors errors, Model model, @RequestParam List<Integer> contacts, @RequestParam List<Integer> medications, @RequestParam List<Integer> providers, @RequestParam List<String> files) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Patient");

            return "admin/patients/add";
        }
        List<Contact> contactObjs = (List<Contact>) contactRepository.findAllById(contacts);
        newPatient.setContacts(contactObjs);
        List<Medication> medicationObjs = (List<Medication>) medicationsRepository.findAllById(medications);
        newPatient.setMedications(medicationObjs);
        List<Provider> providerObjs = (List<Provider>) providersRepository.findAllById(providers);
        newPatient.setProviders(providerObjs);
        List<File> fileObjs = (List<File>) fileRepository.findAllById(files);
        newPatient.setFiles(fileObjs);

        patientRepository.save(newPatient);

        return "redirect:";
    }

    @RequestMapping("/admin/providers")
    public String providersIndex (Model model) {
        model.addAttribute("title", "All Providers");
        model.addAttribute("providers", providersRepository.findAll());
        return "admin/providers/index";
    }

    @RequestMapping("/admin/users")
    public String usersIndex (Model model) {
        model.addAttribute("title", "All Users");
        model.addAttribute("contacts", userRepository.findAll());
        return "admin/users/index";
    }
}
