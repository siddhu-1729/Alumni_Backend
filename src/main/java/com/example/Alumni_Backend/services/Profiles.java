package com.example.Alumni_Backend.services;

//import com.example.Alumni_Backend.DTO.StudentProfileRequest;
import com.example.Alumni_Backend.models.User;

public interface Profiles {

    public User studentProfileRequest(String username);
    public User alumniProfileRequest(String username);
    public User staffProfileRequest(String username);
    public User adminProfileRequest(String username);
}
