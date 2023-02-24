package com.dlniemann.digitalpersonalorganizer.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dlniemann.digitalpersonalorganizer.models.File

@Repository
public interface FilesRepository extends CrudRepository <File, Integer> {
}
