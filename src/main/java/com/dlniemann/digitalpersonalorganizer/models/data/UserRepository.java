package com.dlniemann.digitalpersonalorganizer.models.data;

import com.dlniemann.digitalpersonalorganizer.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUserId(Integer userId);


}