package com.mukti.employee_management_system.service;

import org.springframework.context.annotation.Profile;

@Profile("prod")
public class ProdNotificationService implements NotificationService {
    @Override
    public void sendWelcomeNotification(String email){
        System.out.println("Production notification sent to : "+email);
    }
}
