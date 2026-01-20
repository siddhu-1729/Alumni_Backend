package com.example.Alumni_Backend.controllers;

import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.services.Profiles;
import com.example.Alumni_Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
public class Staff {
   @Autowired
    UserService userService;
   @Autowired
   Profiles profiles;

   @GetMapping
   public User staffProfileRequest(Authentication auth){
       String username= auth.getName();
       return profiles.staffProfileRequest(username);
   }

    @GetMapping("/all")
    public List<User> hello(){
      return userService.getStaff();
    }
    @GetMapping("/data")
    public UserDetails get(@PathVariable String username){
        return userService.userDetailsService().loadUserByUsername(username);
    }
}
