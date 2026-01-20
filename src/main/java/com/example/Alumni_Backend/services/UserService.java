package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService{
    UserDetailsService userDetailsService();

    List<User> getAdmin();
    List<User> getAlumni();
    List<User> getStudent();
    List<User> getStaff();
}
