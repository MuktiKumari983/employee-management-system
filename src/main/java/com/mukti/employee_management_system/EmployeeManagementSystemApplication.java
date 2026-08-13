package com.mukti.employee_management_system;

import com.mukti.employee_management_system.springcore.EmployeeService;
import com.mukti.employee_management_system.springcore.PrototypeDemo;
import com.mukti.employee_management_system.springcore.ReportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(EmployeeManagementSystemApplication.class, args);
        EmployeeService employeeService=context.getBean(EmployeeService.class);
        ReportService reportService=context.getBean(ReportService.class);
        employeeService.checkEmailService();
        reportService.checkService();
	}

}
