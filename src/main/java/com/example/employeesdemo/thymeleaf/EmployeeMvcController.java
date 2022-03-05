package com.example.employeesdemo.thymeleaf;

import com.example.employeesdemo.entity.Employee;
import com.example.employeesdemo.thymeleaf.services.EmployeeService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Data
@Controller
@RequestMapping("/employee")
@Slf4j
public class EmployeeMvcController {

    private final EmployeeService employeeService;

    @GetMapping()
    public String listEmployees(Model model) {
        List<Employee> employeesList = employeeService.getAllEmployees();
        log.info("employeesList size: {}", employeesList.size());
        model.addAttribute("employeesList", employeesList);
        return "employees-list";
    }
}
