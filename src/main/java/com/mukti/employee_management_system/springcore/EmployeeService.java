package com.mukti.employee_management_system.springcore;

import com.mukti.employee_management_system.model.Employee;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmailService emailService;
    private final ScopeDemo scopeDemo;
    public EmployeeService(EmployeeRepository employeeRepository,EmailService emailService,ScopeDemo scopeDemo){
        this.employeeRepository=employeeRepository;
        this.emailService=emailService;
        this.scopeDemo=scopeDemo;
    }
    public void saveEmployee(){
        emailService.sendEmail();
        scopeDemo.checkScope();
    }
    public void checkEmailService(){
        System.out.println("Email Service "+emailService);
    }
    public List<Employee> getEmployee(){
        return employeeRepository.getEmployee();
    }
    public List<Employee> getHighSalaryEmployee(){
        return employeeRepository.getEmployee().
                stream()
                .filter(employee -> employee.getSalary()>=50000)
                .toList();
    }
    public List<Employee> getEmployeesByDepartment(String department){
        return  employeeRepository.getEmployee().
                stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .toList();
    }
    public int count(){
        return employeeRepository.getEmployee().size();
    }
}
