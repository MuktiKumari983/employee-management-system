package com.mukti.employee_management_system.springcore;

import com.mukti.employee_management_system.exception.EmployeeNotFoundException;
import com.mukti.employee_management_system.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        return employeeRepository.findBySalaryGreaterThanEqual(80000);
    }
    public Employee addEmployees(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee getEmployeesById( int id){
        return employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee with id"+id+"not found"));
    }
    public List<Employee> searchSalaryEmployee(double salary){
        return employeeRepository.findBySalary(salary);
    }
    public List<Employee> getEmployeesByDepartment(String department){
        return  employeeRepository.findByDepartment(department);
    }
    public long count(){
        return employeeRepository.count();
    }
    @Transactional
    public Employee updateEmployee(int id, Employee employee){
        if(!employeeRepository.existsById(id)){
            return null;
        }
        employee.setId(id);
        return employeeRepository.save(employee);
    }
    public boolean deleteEmployee(int id){
        if(!employeeRepository.existsById(id)){
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }
    @Transactional
    public Employee updateSalary(int id,double salary){
        Employee employee=employeeRepository.findById(id).orElse(null);
        if(employee==null){
            return null;
        }
        employee.setSalary(salary);
        return employee;
    }
    public Page<Employee> getEmployees(int page,int size){
        Pageable pageable= PageRequest.of(page,size);
        return employeeRepository.findAll(pageable);
    }

}
