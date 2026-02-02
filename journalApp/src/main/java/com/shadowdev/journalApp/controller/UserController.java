package com.shadowdev.journalApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shadowdev.journalApp.entity.User;
import com.shadowdev.journalApp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    public UserService userService;
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }
    @PutMapping("/{userName}")
    public ResponseEntity<User> getUserById(@RequestBody User user,@PathVariable String userName) {
        User existingUser=userService.getUserByUsername(userName);
        if(existingUser!=null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            userService.saveUser(existingUser);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

       
    }
    

    
    


}