package com.mukti.employee_management_system.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties("employee")
public class EmployeeProperties {
    private String companyName;
    private int maxEmployees;
    private String defaultDepartment;
}
