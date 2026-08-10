package com.mukti.employee_management_system.springcore;

import org.springframework.stereotype.Component;

@Component
public class EmailService {
    public void sendEmail(){
        System.out.println("Email Service Bean is working ");
    }
}
