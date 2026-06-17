package com.example.Alumni_Backend.services;

//import com.example.Alumni_Backend.DTO.StudentProfileRequest;
import com.example.Alumni_Backend.models.User;

public interface Profiles {
//to get all profiles of the users from the database

     User studentProfileRequest(String username);
     User alumniProfileRequest(String username);
     User staffProfileRequest(String username);
     User adminProfileRequest(String username);
}
