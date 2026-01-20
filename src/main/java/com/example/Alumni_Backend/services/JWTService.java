package com.example.Alumni_Backend.services;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTService {
    String generateToken(UserDetails userDetails);
    String generateRefreshToken(Map<String,Object> extractClaims, UserDetails userDetails);
    String extractUsername(String token);
    boolean isTokenValid(String token ,UserDetails userDetails);
}
