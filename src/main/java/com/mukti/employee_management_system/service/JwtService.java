package com.mukti.employee_management_system.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private long expiration;
    private  SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }
    public String generateToken(String username){
        return Jwts.builder().subject(username).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+1000*60*60)).signWith(getSigningKey()).compact();
    }
    public String extractUsername(String token){
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }
    public boolean isTokenValid(String token, UserDetails userDetails) {

        String username = extractUsername(token);

        boolean usernameMatches =
                username.equals(userDetails.getUsername());

        boolean tokenExpired =
                isTokenExpired(token);

        System.out.println("JWT username: " + username);
        System.out.println("DB username: " + userDetails.getUsername());
        System.out.println("Username matches: " + usernameMatches);
        System.out.println("Token expired: " + tokenExpired);

        return usernameMatches && !tokenExpired;
    }
    public boolean isTokenExpired(String token){
        Date expiration=Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getExpiration();
        return expiration.before(new Date());
    }
}
