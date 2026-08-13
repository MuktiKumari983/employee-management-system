package com.mukti.employee_management_system.springcore;

import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final EmailService emailService;
    public ReportService(EmailService emailService){
        this.emailService=emailService;
    }
    public void checkService(){
        System.out.println("Report Service "+emailService);
    }

}
