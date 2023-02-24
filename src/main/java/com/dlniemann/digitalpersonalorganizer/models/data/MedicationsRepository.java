package com.dlniemann.digitalpersonalorganizer.models.data;

import com.dlniemann.digitalpersonalorganizer.models.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MedicationsRepository extends CrudRepository<Medication, Integer>{
}
