package com.mukti.employee_management_system.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "Username must required")
    private String username;
    @NotBlank(message = "Password must required")
    private String password;
}
