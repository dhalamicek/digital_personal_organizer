package com.dlniemann.digitalpersonalorganizer.models.data;

import com.dlniemann.digitalpersonalorganizer.models.Relationship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends CrudRepository<Relationship, Integer> {
}
