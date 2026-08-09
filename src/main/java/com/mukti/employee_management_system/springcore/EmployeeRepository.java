package com.mukti.employee_management_system.springcore;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    public void save(){
        System.out.println("Employee saved successfully");
    }
}
