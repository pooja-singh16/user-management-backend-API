package com.example.internship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.internship.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Boot automatically handles all standard database operations here!
}