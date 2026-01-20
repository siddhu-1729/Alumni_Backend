package com.example.Alumni_Backend.services.impl;

import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.repository.UserRepo;
import com.example.Alumni_Backend.services.Profiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilesImp implements Profiles {
    @Autowired
    private UserRepo userRepo;

    public User studentProfileRequest(String username){
       return userRepo.findByUsername(username).orElseThrow(()->new RuntimeException("Profile Not Found"));
    }
    public User alumniProfileRequest(String username){
        return userRepo.findByUsername(username).orElseThrow(()->new RuntimeException("Profile Not Found"));
    }

    public User staffProfileRequest(String username){
        return userRepo.findByUsername(username).orElseThrow(()->new RuntimeException("Profile Not Found"));
    }

    public User adminProfileRequest(String username){
        return userRepo.findByUsername(username).orElseThrow(()->new RuntimeException("Admin Not Found"));
    }
}
