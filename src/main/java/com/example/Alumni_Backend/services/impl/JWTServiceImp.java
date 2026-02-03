package com.example.Alumni_Backend.services.impl;

import com.example.Alumni_Backend.services.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTServiceImp implements JWTService {

    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*24*60*60))
                .signWith(getsigningkey() , SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateRefreshToken(Map<String,Object> extractClaims, UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+60480000))
                .signWith(getsigningkey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getsigningkey(){
        byte[] key = Decoders.BASE64.decode("4fa3b7c1d9e04e2fb7f1298e7e31373812a8c91bdd9b18ef5f0a0c41dfe6bd7e");
        return Keys.hmacShaKeyFor(key);
    }

    public String extractUsername(String token){
        return extractClaim(token , Claims::getSubject);
    }

    private <T> T  extractClaim(String token , Function<Claims , T> claimsResolver){
        final Claims claim= extractAllClaims(token);
        return claimsResolver.apply(claim);
    }

    private Claims extractAllClaims(String token){
      return Jwts.parserBuilder().setSigningKey(getsigningkey()).build().parseClaimsJws(token).getBody();
    }

    public boolean isTokenValid(String token ,UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token){
        return extractClaim(token , Claims::getExpiration).before(new Date());
    }

}
