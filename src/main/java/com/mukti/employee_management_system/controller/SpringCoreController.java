package com.mukti.employee_management_system.controller;

import com.mukti.employee_management_system.springcore.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringCoreController {
    private final EmployeeService employeeService;
    public SpringCoreController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/spring-core")
    public String test(){
        employeeService.saveEmployee();
        return "Dependency injection is working";
    }
}
