package com.example.employeesdemo.controller;

import com.example.employeesdemo.entity.Employee;
import com.example.employeesdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        Optional<Employee> maybeEmployee = repository.findById(id);

        if(maybeEmployee.isPresent()){
            return new ResponseEntity(maybeEmployee.get(), HttpStatus.OK);
        }

        return new ResponseEntity(new Employee(), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/employees")
    public Employee getEmployees(@RequestBody Employee employee) {
//        Employee newEmployee = new Employee(employee.getName());
        return repository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void getEmployees(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
