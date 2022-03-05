package com.example.employeesdemo.controller;

import com.example.employeesdemo.entity.Employee;
import com.example.employeesdemo.thymeleaf.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeServiceImpl.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        Employee employee = employeeServiceImpl.getEmployeeById(id);

        return new ResponseEntity(employee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public Employee getEmployees(@RequestBody Employee employee) {
        return employeeServiceImpl.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void getEmployees(@PathVariable Long id) {
        employeeServiceImpl.deleteEmployee(id);
    }
}
