package com.mukti.employee_management_system.controller;

import com.mukti.employee_management_system.model.Employee;
import com.mukti.employee_management_system.springcore.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping
    public Employee getEmployees(){
        return employeeService.getEmployee();
    }
    @PostMapping
    public String addEmployees(){
        return "Employee added";
    }
    @PutMapping("/{id}")
    public String updateEmployees(@PathVariable int id){
        return "Employee "+id+" updated";
    }
    @DeleteMapping("/{id}")
    public String deleteEmployees(@PathVariable int id){
        return "Employee "+id+" deleted";
    }
    @PatchMapping("/{id}")
    public String patchEmployee(@PathVariable int id){
        return "Employee "+id+" partially updated";
    }
}
