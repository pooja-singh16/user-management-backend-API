package com.example.internship.controller;

import com.example.internship.model.User;
import com.example.internship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // GET all users from the database
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // POST a new user to the database
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}