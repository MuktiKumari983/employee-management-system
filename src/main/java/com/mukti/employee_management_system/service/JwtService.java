package com.mukti.employee_management_system.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    private final String SECRET_KEY="my-super-secret-key-for-employee-management-system-2026";
    private final SecretKey key= Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    public String generateToken(String username){
        return Jwts.builder().subject(username).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+1000*60*60)).signWith(key).compact();
    }
    public String extractUsername(String token){
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
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
        Date expiration=Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getExpiration();
        return expiration.before(new Date());
    }
}
