package com.mukti.employee_management_system.springcore;

import com.mukti.employee_management_system.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    public Employee getEmployee(){
        return new Employee(1,
                "Mukti",
                "mukti@example.com",
                "CSE",
                50000);
    }
}
