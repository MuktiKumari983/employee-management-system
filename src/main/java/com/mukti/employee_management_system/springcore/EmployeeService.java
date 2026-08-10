package com.mukti.employee_management_system.springcore;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final EmailService emailService;
    public EmployeeService(EmployeeRepository repository,EmailService emailService){
        this.repository=repository;
        this.emailService=emailService;
    }
    public void saveEmployee(){
        repository.save();
        emailService.sendEmail();
    }
}
