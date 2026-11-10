package com.mukti.employee_management_system.service;

import com.mukti.employee_management_system.exception.EmployeeNotFoundException;
import com.mukti.employee_management_system.model.Employee;
import com.mukti.employee_management_system.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private  EmployeeService employeeService;
    @Mock
    private NotificationService notificationService;
    @Test
    void testGetEmployeeById(){
        Employee employee=new Employee();
        employee.setId(1);
        employee.setName("Andres Muhlach");
        employee.setEmail("muhlachandres@gmail.com");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
        Employee result=employeeService.getEmployeesById(1);
        assertNotNull(result);
        assertEquals(1,result.getId());
        assertEquals("Andres Muhlach",result.getName());

    }
    @Test
    void testGetEmployeeByIdNotFound(){
        when(employeeRepository.findById(100)).thenReturn(Optional.empty());
        assertThrows(EmployeeNotFoundException.class,()->employeeService.getEmployeesById(100));
    }
    @Test
    void testAddEmployee(){
        Employee employee=new Employee();
        employee.setName("Mark Kiefer Watson");
        employee.setEmail("kieferwatson@gmail.com");
        employee.setDepartment("IT");
        employee.setSalary(100000);
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee result=employeeService.addEmployees(employee);
        assertNotNull(result);
        assertEquals("Mark Kiefer Watson",result.getName());
        verify(employeeRepository,times(1)).save(any(Employee.class));

    }
    @Test
    void testUpdateEmployee(){
        Employee existing=new Employee();
        existing.setId(1);
        existing.setName("Mukti");
        Employee updated=new Employee();
        updated.setName("Mukti Watson");
        updated.setEmail("muktiwatson@gmail.com");
        updated.setDepartment("IT");
        updated.setSalary(60000);
        when(employeeRepository.findById(1)).thenReturn(Optional.of(existing));
        when(employeeRepository.save(any(Employee.class))).thenReturn(existing);
        Employee result=employeeService.updateEmployee(1,updated);
        assertEquals("Mukti Watson",result.getName());
        verify(employeeRepository).findById(1);
        verify(employeeRepository).save(any(Employee.class));
    }
    @Test
    void testUpdateEmployeeNotFound(){
        Employee updated=new Employee();
        when(employeeRepository.findById(100)).thenReturn(Optional.empty());
        assertThrows(EmployeeNotFoundException.class,()->employeeService.updateEmployee(100,updated));
        verify(employeeRepository,never()).save(any(Employee.class));
    }
    @Test
    void testDeleteEmployee(){
        when(employeeRepository.existsById(1)).thenReturn(true);
        employeeService.deleteEmployee(1);
        verify(employeeRepository).deleteById(1);
    }
    @Test
    void testDeleteEmployeeNotFound(){
        when(employeeRepository.existsById(100)).thenReturn(false);
        assertThrows(EmployeeNotFoundException.class,()->employeeService.deleteEmployee(100));
        verify(employeeRepository,never()).deleteById(100);
    }
}
