package com.mukti.employee_management_system.controller;

import com.mukti.employee_management_system.dto.RegisterRequest;
import com.mukti.employee_management_system.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mukti.employee_management_system.model.User;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService=authService;
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterRequest request){
        User user=authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
