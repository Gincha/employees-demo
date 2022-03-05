package com.example.employeesdemo.controller;

import com.example.employeesdemo.entity.Employee;
import com.example.employeesdemo.repository.EmployeeRepository;
import com.example.employeesdemo.thymeleaf.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);

        return new ResponseEntity(employee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public Employee getEmployees(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void getEmployees(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
