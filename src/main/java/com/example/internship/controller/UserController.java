package com.example.internship.controller;

import com.example.internship.model.User;
import com.example.internship.repository.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    // Constructor Injection
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // =========================
    // CREATE USER
    // POST /users
    // =========================
    @PostMapping
    public User createUser(@RequestBody User user) {

        return userRepository.save(user);
    }

    // =========================
    // GET ALL USERS
    // GET /users
    // =========================
    @GetMapping
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    // =========================
    // GET USER BY ID
    // GET /users/{id}
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // =========================
    // UPDATE USER
    // PUT /users/{id}
    // =========================
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User updatedUser) {

        return userRepository.findById(id)
                .map(user -> {

                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    user.setPhone(updatedUser.getPhone());

                    User savedUser = userRepository.save(user);

                    return ResponseEntity.ok(savedUser);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // =========================
    // DELETE USER
    // DELETE /users/{id}
    // =========================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        if (!userRepository.existsById(id)) {

            return ResponseEntity.notFound().build();
        }

        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}