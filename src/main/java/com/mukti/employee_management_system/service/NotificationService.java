package com.mukti.employee_management_system.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {
    @Async
    public void sendWelcomeNotification(String email){
        log.info("Starting notification for: {}",email);
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            log.error("Notification interrupted ",e);
            return;
        }
        log.info("Notification completed for: {}",email);
    }
}
