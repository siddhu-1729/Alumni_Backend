package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.DTO.JWTAuthenticationResponse;
import com.example.Alumni_Backend.DTO.RefreshTokenRequest;
import com.example.Alumni_Backend.DTO.SigninRequest;
import com.example.Alumni_Backend.DTO.SignupRequest;
import com.example.Alumni_Backend.models.User;
import jakarta.mail.MessagingException;

import java.util.List;

public interface AuthenticationService {
    User staffsignup(SignupRequest signupRequest);
    User studentsignup(SignupRequest signupRequest);
    User alumnisignup(SignupRequest signupRequest);
    JWTAuthenticationResponse signin(SigninRequest signinRequest);
    JWTAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    List<String> allEmails();
    String sendEmailUpdates() throws MessagingException;
}
