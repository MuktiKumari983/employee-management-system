package com.mukti.employee_management_system.springcore;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifecycleDemo {
    public LifecycleDemo(){
        System.out.println("1. Constructor- Bean Created");
    }
    @PostConstruct
    public void init(){
        System.out.println("2. @PostConstructor- Bean Initiated");
    }
    @PreDestroy
    public  void destroy(){
        System.out.println("3. @PreDestroy- Bean Destroyed");
    }
}
