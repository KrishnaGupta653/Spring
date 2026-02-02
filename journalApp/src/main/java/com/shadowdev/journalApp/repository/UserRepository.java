package com.shadowdev.journalApp.repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.shadowdev.journalApp.entity.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);
    
}
