package com.mukti.employee_management_system.service;

import com.mukti.employee_management_system.model.Employee;
import com.mukti.employee_management_system.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    void testSaveEmployee(){
        Employee employee=new Employee();
        employee.setName("Andres Muhlach");
        employee.setEmail("andresmukti@gmail.com");
        employee.setDepartment("IT");
        employee.setSalary(100000);
        Employee savedEmployee=employeeRepository.save(employee);
        assertNotNull(savedEmployee.getId());
        assertEquals("Andres Muhlach",savedEmployee.getName());
        assertEquals("IT",savedEmployee.getDepartment());
    }
    @Test
    void testFindEmployeeById(){
        Employee employee=new Employee();
        employee.setName("Andres Muhlach");
        employee.setEmail("andresmukti@gmail.com");
        employee.setDepartment("IT");
        employee.setSalary(100000);
        Employee savedEmployee=employeeRepository.save(employee);
        Optional<Employee> result=employeeRepository.findById(savedEmployee.getId());
        assertTrue(result.isPresent());
        assertEquals("Andres Muhlach",result.get().getName());
    }
    @Test
    void testFindAllEmployees(){
        Employee employee1=new Employee();
        employee1.setName("Andres Muhlach");
        employee1.setEmail("andresmukti@gmail.com");
        employee1.setDepartment("IT");
        employee1.setSalary(100000);
        Employee employee2=new Employee();
        employee2.setName("Mark Kiefer Watson");
        employee2.setEmail("kieferwatson@gmail.com");
        employee2.setDepartment("HR");
        employee2.setSalary(150000);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        List<Employee> employees=employeeRepository.findAll();
        assertEquals(2,employees.size());
    }
    @Test
    void testDeleteEmployee(){
        Employee employee=new Employee();
        employee.setName("Andres Muhlach");
        employee.setEmail("andresmukti@gmail.com");
        employee.setDepartment("IT");
        employee.setSalary(100000);
        Employee savedEmployee=employeeRepository.save(employee);
        Integer id=savedEmployee.getId();
        employeeRepository.deleteById(id);
        Optional<Employee> result=employeeRepository.findById(id);
        assertFalse(result.isPresent());
    }

}
