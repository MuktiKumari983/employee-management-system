package com.mukti.employee_management_system.springcore;

import com.mukti.employee_management_system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import  java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByDepartment(String department );
    List<Employee> findBySalary(double salary );
    List<Employee> findBySalaryGreaterThanEqual(double salary );
}
