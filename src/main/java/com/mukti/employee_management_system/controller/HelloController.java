package com.mukti.employee_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String home(){
        return "Welcome Andres Muhlach";
    }
    @GetMapping("/about")
    public String about(){
        return "I am your big fan";
    }
}
