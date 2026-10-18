package com.mukti.employee_management_system.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
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
}
