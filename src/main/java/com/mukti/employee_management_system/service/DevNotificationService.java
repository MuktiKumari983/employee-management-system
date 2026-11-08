package com.mukti.employee_management_system.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevNotificationService implements NotificationService{
    @Override
    public void sendWelcomeNotification(String email){
        System.out.println("Development notification sent to : "+email);
    }
}
