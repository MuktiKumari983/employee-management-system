
package com.mukti.employee_management_system.controller;

import com.mukti.employee_management_system.exception.EmployeeNotFoundException;
import com.mukti.employee_management_system.model.Employee;
import com.mukti.employee_management_system.service.EmployeeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeService employeeService;

    @Test
    void testGetEmployeeById() throws Exception {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Andres Muhlach");
        employee.setEmail("andresmuhlach@gmail.com");
        employee.setDepartment("IT");
        employee.setSalary(100000);

        when(employeeService.getEmployeesById(1))
                .thenReturn(employee);

        mockMvc.perform(get("/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name")
                        .value("Andres Muhlach"));
    }
    @Test
    void testGetEmployeeNotFound() throws Exception{
        when(employeeService.getEmployeesById(100)).thenThrow(new EmployeeNotFoundException("Employee Not found"));
        mockMvc.perform(get("/employees/100")).andExpect(status().isNotFound());
    }
    @Test
    void testAddEmployee() throws Exception{
        Employee employee=new Employee();
        employee.setId(1);
        employee.setName("Mark Kiefer Watson");
        employee.setEmail("kieferwatson@gmail.com");
        employee.setDepartment("IT");
        employee.setSalary(150000);
        when(employeeService.addEmployees(any(Employee.class))).thenReturn(employee);
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content("""
                {
                "name":"Mark Kiefer Watson",
                "email":"kieferwatson@gmail.com",
                "department":"IT",
                "salary":150000
                }
                """)).andExpect(status().isCreated()).andExpect(jsonPath("$.name").value("Mark Kiefer Watson"));
    }
}
