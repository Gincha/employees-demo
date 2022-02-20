package com.example.employeesdemo;

import com.example.employeesdemo.entity.Employee;
import com.example.employeesdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesDemoApplication
//		implements CommandLineRunner
{

	@Autowired
	private EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeesDemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Employee employee = new Employee("John");
//		Employee savedEmployee = repository.save(employee);
//
//		Employee employee2 = new Employee("Doe");
//		Employee savedEmployee2 = repository.save(employee2);
//	}
}
