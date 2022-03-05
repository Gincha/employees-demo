package com.example.employeesdemo.thymeleaf.controller;

import com.example.employeesdemo.entity.Employee;
import com.example.employeesdemo.thymeleaf.services.EmployeeService;
import com.example.employeesdemo.thymeleaf.services.EmployeeServiceImpl;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Controller
@RequestMapping("/employees")
public class EmployeeMvcController {

    private final EmployeeService employeeService;

    @GetMapping()
    public String listEmployees(Model model) {
        List<Employee> employeesList = employeeService.getAllEmployees();
        model.addAttribute("employeesList", employeesList);
        return "employees-list";
    }

    @GetMapping("/form")
    public String employeesForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees-form";
    }

    @GetMapping("/formForUpdate")
    public String employeesFormForUpdate(@RequestParam("employeeId") Long empId, Model model){
        Employee employee = employeeService.getEmployeeById(empId);
        model.addAttribute("employee", employee);
        return "/employees-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
