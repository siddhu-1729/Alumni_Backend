package com.example.Alumni_Backend.controllers;

import com.example.Alumni_Backend.DTO.JWTAuthenticationResponse;
import com.example.Alumni_Backend.DTO.RefreshTokenRequest;
import com.example.Alumni_Backend.DTO.SigninRequest;
import com.example.Alumni_Backend.DTO.SignupRequest;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class Authentications {

    @Autowired
   private AuthenticationService authenticationService;

    @PostMapping("/staffsignup")
    public ResponseEntity<User>  staffsignup(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.ok(authenticationService.staffsignup(signupRequest));
    }
    @PostMapping("/studentsignup")
    public ResponseEntity<User> studentsignup(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.ok(authenticationService.studentsignup(signupRequest));
    }

    @PostMapping("/alumnisignup")
    public ResponseEntity<User> alumnisignup(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.ok(authenticationService.alumnisignup(signupRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JWTAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

    @GetMapping("/allemails")
    public List<String> listEmails(){
        return authenticationService.allEmails();
    }
    @GetMapping("/sendUpdates")
    public String sendUpdates() throws Exception{
        return authenticationService.sendEmailUpdates();
    }


}
