package com.example.employeesdemo.thymeleaf.services;

import com.example.employeesdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);
}
