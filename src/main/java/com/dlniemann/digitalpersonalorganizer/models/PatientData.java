package com.dlniemann.digitalpersonalorganizer.models;

import javax.persistence.Entity;
import java.util.ArrayList;



@Entity
public class PatientData extends PersonEntity {

    //returns the results of searching the Patients data by field and search term

    public static ArrayList<Patient> findByColumnAndValue(String column, String value, Iterable<Patient> allPatients) {

        ArrayList<Patient> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Patient>) allPatients;
        }

        if (column.equals("all")) {
            results = findByValue(value, allPatients);
            return results;
        }
        for (Patient patient : allPatients) {

            String aValue = getFieldValue(patient, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(patient);
            }
        }
        return results;
    }

    public static String getFieldValue(Patient patient, String fieldName) {
        String theValue;
        if(fieldName.equals("firstName")){
            theValue = patient.getFirstName();
        } else if (fieldName.equals("lastName")){
            theValue = patient.getLastName();
        } else if (fieldName.equals("dOB")) {
            theValue = patient.getDOB();
        } else if (fieldName.equals("contacts")) {
            theValue = patient.getContacts().toString();
        } else if (fieldName.equals("medications")) {
            theValue = patient.getMedications().toString();
        } else if (fieldName.equals("providers")) {
            theValue = patient.getProviders().toString();
        } else {
            theValue = patient.getFiles().toString();
        }
        return theValue;
    }


    //Search all Patient fields for the given term
//how do I include to search by phone number since not a string?
    public static ArrayList<Patient> findByValue(String value, Iterable<Patient> allPatients) {
        String lower_val = value.toLowerCase();

        ArrayList<Patient> results = new ArrayList<>();

        for (Patient patient : allPatients) {
            if (patient.getFirstName().toLowerCase().contains(lower_val)) {
                results.add(patient);
            } else if (patient.getLastName().toLowerCase().contains(lower_val)) {
                results.add(patient);
            } else if (patient.getPhoneNumber().toLowerCase().contains(lower_val)) {
                results.add(patient);
            } else if (patient.getEmail().toLowerCase().contains(lower_val)) {
                results.add(patient);
            } else if (patient.getContacts().toString().toLowerCase().contains(lower_val)) {
                results.add(patient);
            } else if (patient.getMedications().toString().toLowerCase().contains(lower_val)) {
                results.add(patient);
            } else if (patient.getProviders().toString().toLowerCase().contains(lower_val)) {
                results.add(patient);
            } else if (patient.getFiles().toString().toLowerCase().contains(lower_val)) {
                results.add(patient);
            }
        }
        return results;
    }
}
