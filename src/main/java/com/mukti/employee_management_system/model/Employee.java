package com.mukti.employee_management_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name should be between 2 to 50 characters")
    private String name;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Department is required")
    private String department;
    @Positive(message = "Salary must be greater than 0")
    @Max(value = 100000, message = "Salary cannot be exceed 100000")
    private double salary;
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
