package com.mukti.employee_management_system.springcore;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final EmailService emailService;
    private final ScopeDemo scopeDemo;
    public EmployeeService(EmployeeRepository repository,EmailService emailService,ScopeDemo scopeDemo){
        this.repository=repository;
        this.emailService=emailService;
        this.scopeDemo=scopeDemo;
    }
    public void saveEmployee(){
        repository.save();
        emailService.sendEmail();
        scopeDemo.checkScope();
    }
    public void checkEmailService(){
        System.out.println("Email Service "+emailService);
    }
}
