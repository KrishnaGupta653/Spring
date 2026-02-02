package com.shadowdev.journalApp.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shadowdev.journalApp.entity.User;
import com.shadowdev.journalApp.repository.UserRepository;

@Component
public class UserService {
    @Autowired UserRepository userRepository;
    //save
    public void saveUser(User user) {
        userRepository.save(user);
    }
    //get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    //get user by id
    public User getUserById(ObjectId Id) {
        return userRepository.findById(Id).orElse(null);
    }
    //get user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    //delete user by id 
    public void deleteUserById(ObjectId id) {
        userRepository.deleteById(id);
    }
    
    
}
