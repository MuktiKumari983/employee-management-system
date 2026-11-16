package com.mukti.employee_management_system.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employees")
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Employee Information")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Employee ID",example = "1")
    private int id;
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name should be between 2 to 50 characters")
    @Schema(description = "Employee name",example = "Andres Muhlach")
    private String name;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Schema(description = "Employee email",example = "andresmuhlach@gmail.com")
    private String email;
    @NotBlank(message = "Department is required")
    @Schema(description = "Employee department",example = "IT")
    private String department;
    @Positive(message = "Salary must be greater than 0")
    @Max(value = 100000, message = "Salary cannot be exceed 100000")
    @Schema(description = "Employee salary",example = "100000")
    private double salary;
    @Builder
    public Employee(String name, String department, String email, double salary){
        this.name=name;
        this.department=department;
        this.email=email;
        this.salary=salary;
    }
    public void setId(int id) {
        this.id = id;
    }
}
