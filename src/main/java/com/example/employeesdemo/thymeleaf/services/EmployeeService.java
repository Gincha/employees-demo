package com.example.employeesdemo.thymeleaf.services;

import com.example.employeesdemo.entity.Employee;
import com.example.employeesdemo.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> maybeEmployee = repository.findById(id);

        if (maybeEmployee.isEmpty()) {
            throw new RuntimeException("Employee with id " + id + " was not found.");
        }

        return maybeEmployee.get();
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
