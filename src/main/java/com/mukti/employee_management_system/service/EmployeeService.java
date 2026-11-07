package com.mukti.employee_management_system.service;

import com.mukti.employee_management_system.exception.EmployeeNotFoundException;
import com.mukti.employee_management_system.model.Employee;
import com.mukti.employee_management_system.repository.EmployeeRepository;
import com.mukti.employee_management_system.springcore.ScopeDemo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
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
        log.info("Email Service "+emailService);
    }
    public List<Employee> getEmployee(){
        log.info("Fetching all employees");
        List<Employee> employees=employeeRepository.findAll();
        log.info("Fetched {} employees",employees.size());
        return employees;
    }
    public List<Employee> getHighSalaryEmployee(){
        return employeeRepository.findBySalaryGreaterThanEqual(80000);
    }
    public Employee addEmployees(Employee employee){
        log.info("Creating employee with email: {}",employee.getEmail());
        Employee savedEmployee=employeeRepository.save(employee);
        log.info("Employee created successfully with id: {}",savedEmployee.getId());
        return savedEmployee;
    }
    @Cacheable(value ="employees",key = "#id")
    public Employee getEmployeesById( int id){
        log.info("Fetching employee with id {}",id);
        return employeeRepository.findById(id)
                .orElseThrow(()->{
                    log.warn( "Employee with id {} not found",id);
                    return  new EmployeeNotFoundException("Employee with id"+id+"not found");
                });
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
    @Cacheable(value = "employees",key = "#id")
    public Employee updateEmployee(int id, Employee employee){
        log.info("Updating employee with id: {}",id);
       Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()-> {
           log.info("Cannot update. Employee with id {} not found",id);
        return new EmployeeNotFoundException("Employee with id "+id+" not found");
               });
        employee.setId(existingEmployee.getId());
        Employee updatedEmployee=employeeRepository.save(employee);
        log.info("Employee with id {} updated successfully",id);
        return updatedEmployee;

    }
    public void testBuilder() {
        Employee employee = Employee.builder()
                .name("Builder Test")
                .email("builder@example.com")
                .department("CSE")
                .salary(70000)
                .build();
        log.info("Builder created employee: {}",employee);
    }
    @Cacheable(value = "employees",key = "#id")
    public void deleteEmployee(int id){
        log.info("Deleting employee with id: {}",id);
        if(!employeeRepository.existsById(id)){
            log.info("Cannot delete. Employee with id {} not found",id);
            throw new EmployeeNotFoundException("Employee with id "+id+" not found");
        }
        employeeRepository.deleteById(id);
        log.info("Employee with id {} deleted successfully",id);
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
        log.info("Fetching employees - pages: {}, size: {}",page,size);
        Pageable pageable= PageRequest.of(page,size);
       Page<Employee> employees= employeeRepository.findAll(pageable);
       log.info("Fetched {} employees from current page",employees.getTotalElements());
       return employees;
    }

}
