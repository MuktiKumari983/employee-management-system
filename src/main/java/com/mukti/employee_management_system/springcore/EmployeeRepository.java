package com.mukti.employee_management_system.springcore;

import com.mukti.employee_management_system.model.Employee;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import  java.util.List;

@Repository
public class EmployeeRepository {
    public List<Employee> getEmployee(){
        List<Employee> employees=new ArrayList<>();
        employees.add( new Employee(1,
                "Mukti",
                "CSE",
                "mukti@example.com",
                50000));
        employees.add(new Employee(2,
                "Rahul",
                "IT",
                "rahul@example.com",
                60000
                ));
        employees.add(new Employee(3,
                "Anjali",
                "HR",
                "anjali@example.com",
                45000));
        return employees;
    }
}
