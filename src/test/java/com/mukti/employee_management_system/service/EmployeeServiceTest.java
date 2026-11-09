package com.mukti.employee_management_system.service;

import com.mukti.employee_management_system.exception.EmployeeNotFoundException;
import com.mukti.employee_management_system.model.Employee;
import com.mukti.employee_management_system.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private  EmployeeService employeeService;
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
}
