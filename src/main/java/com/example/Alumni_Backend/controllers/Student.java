package com.example.Alumni_Backend.controllers;

//import com.example.Alumni_Backend.DTO.StudentProfileRequest;
import com.example.Alumni_Backend.DTO.ArticleRequest;
import com.example.Alumni_Backend.models.SuccessStories;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.services.Profiles;
import com.example.Alumni_Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class Student {

    @Autowired
    UserService userService;
    @Autowired
    Profiles profiles;

    @GetMapping
     public User studentProfileRequest(Authentication authentication){
          String username=authentication.getName();
         return profiles.studentProfileRequest(username);
     }

    @GetMapping("all")
    public List<User> hello(){
        return userService.getStudent();
    }

    @GetMapping("/data")
    public UserDetails get(@PathVariable String username){
        return userService.userDetailsService().loadUserByUsername(username);
    }

//    @GetMapping("/profile")
//    public StudentProfileRequest studentProfileRequest(){
//        return userService.
//    }

    @PostMapping("/share_story")
    public SuccessStories postStory(@RequestBody ArticleRequest articleRequest){
        return  userService.successStories(articleRequest);
    }
}
