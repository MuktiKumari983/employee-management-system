package com.mukti.employee_management_system.controller;

import com.mukti.employee_management_system.model.Employee;
import com.mukti.employee_management_system.springcore.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployee();
    }
    @GetMapping("/high-salary")
    public List<Employee> getHighSalaryEmployees( ){
        return employeeService.getHighSalaryEmployee();
    }
    @GetMapping("/salary")
    public List<Employee> searchSalaryEmployees(@RequestParam double salary ){
        return employeeService.searchSalaryEmployee(salary);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeesById(@PathVariable int id){
        Employee employee= employeeService.getEmployeesById(id);
        if(employee==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }
    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department){
        return employeeService.getEmployeesByDepartment(department);
    }
    @GetMapping("/search")
    public List<Employee> searchEmployee(@RequestParam(defaultValue = "IT") String department){
        return employeeService.getEmployeesByDepartment(department);
    }
    @GetMapping("/count")
    public long count(){ return employeeService.count();}
    @PostMapping
    public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee){
        Employee savedEmployee=employeeService.addEmployees(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }
    @PutMapping("/{id}")
    public String updateEmployees(@PathVariable int id){
        return "Employee "+id+" updated";
    }
    @DeleteMapping("/{id}")
    public String deleteEmployees(@PathVariable int id){
        return "Employee "+id+" deleted";
    }
    @PatchMapping("/{id}")
    public String patchEmployee(@PathVariable int id){
        return "Employee "+id+" partially updated";
    }
}
