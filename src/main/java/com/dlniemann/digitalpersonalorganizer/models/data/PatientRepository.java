package com.dlniemann.digitalpersonalorganizer.models.data;

import com.dlniemann.digitalpersonalorganizer.models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer>{
}
