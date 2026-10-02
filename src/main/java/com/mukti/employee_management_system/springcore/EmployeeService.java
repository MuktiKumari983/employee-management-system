package com.mukti.employee_management_system.springcore;

import com.mukti.employee_management_system.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
        return employeeRepository.findAll();
    }
    public List<Employee> getHighSalaryEmployee(){
        return employeeRepository.findAll().
                stream()
                .filter(employee -> employee.getSalary()>=80000)
                .toList();
    }
    public Employee addEmployees(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee getEmployeesById( int id){
        return employeeRepository.findById(id)
                .orElse(null);
    }
    public List<Employee> searchSalaryEmployee(double salary){
        return employeeRepository.findAll().
                stream()
                .filter(employee -> employee.getSalary()==salary)
                .toList();
    }
    public List<Employee> getEmployeesByDepartment(String department){
        return  employeeRepository.findAll().
                stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .toList();
    }
    public long count(){
        return employeeRepository.count();
    }
}
