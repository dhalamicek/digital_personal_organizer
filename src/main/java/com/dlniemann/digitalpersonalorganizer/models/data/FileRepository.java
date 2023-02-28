package com.dlniemann.digitalpersonalorganizer.models.data;

import com.dlniemann.digitalpersonalorganizer.models.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//not sure if I need this or not
@Repository
public interface FileRepository extends JpaRepository<DBFile, String> {
}
