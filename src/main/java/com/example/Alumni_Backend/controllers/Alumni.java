package com.example.Alumni_Backend.controllers;


import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.services.Profiles;
import com.example.Alumni_Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumni")
public class Alumni {

    @Autowired
    UserService userService;
    @Autowired
    Profiles profiles;

    @GetMapping
    public User alumniProfileRequest(Authentication auth){
        String username= auth.getName();
        return profiles.alumniProfileRequest(username);
    }

    @GetMapping("/all")
    public List<User> hello(){
        return userService.getAlumni();
    }

    @GetMapping("/data")
    public UserDetails get(@PathVariable String username){

        return userService.userDetailsService().loadUserByUsername(username);
    }
}
