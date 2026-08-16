package com.mukti.employee_management_system.model;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String department;
    private double salary;
    public Employee(int id, String name, String department, String email, double salary){
        this.id=id;
        this.name=name;
        this.department=department;
        this.email=email;
        this.salary=salary;
    }
     public Employee(){

     }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
