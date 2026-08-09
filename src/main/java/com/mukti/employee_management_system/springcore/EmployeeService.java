package com.mukti.employee_management_system.springcore;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository){
        this.repository=repository;
    }
    public void saveEmployee(){
        repository.save();
    }
}
