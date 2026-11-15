package com.mukti.employee_management_system.service;

import com.mukti.employee_management_system.model.Employee;
import com.mukti.employee_management_system.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeServiceIntegrationTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    void testAddAndGetEmployee(){
        Employee employee=new Employee();
        employee.setName("Andres Muhlach");
        employee.setEmail("andresmukti@gmail.com");
        employee.setDepartment("IT");
        employee.setSalary(100000);
        Employee savedEmployee=employeeService.addEmployees(employee);
        assertNotNull(savedEmployee.getId());
        Employee result=employeeService.getEmployeesById(savedEmployee.getId());
        assertEquals("Andres Muhlach",result.getId());
        assertEquals("andresmukti@gmail.com",result.getEmail());
    }
}
