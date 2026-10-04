package com.mukti.employee_management_system.model;

import jakarta.persistence.*;
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
    private String name;
    private String email;
    private String department;
    private double salary;
    public Employee(String name, String department, String email, double salary){
        this.name=name;
        this.department=department;
        this.email=email;
        this.salary=salary;
    }
}
