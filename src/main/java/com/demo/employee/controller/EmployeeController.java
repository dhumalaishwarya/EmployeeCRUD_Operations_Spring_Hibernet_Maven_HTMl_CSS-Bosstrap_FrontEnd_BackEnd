package com.demo.employee.controller;

import com.demo.employee.model.Employee;
import com.demo.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Display all employees
    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", service.getAllEmployees());
        return "employees"; // Thymeleaf template: employees.html
    }

    // Show create employee form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "create_employee"; // Thymeleaf template: create_employee.html
    }

    // Save new employee
    @PostMapping
    public String saveEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/employees";
    }

    // Show edit form for a specific employee
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Employee employee = service.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit_employee"; // Thymeleaf template: edit_employee.html
    }

    // Update employee
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @ModelAttribute Employee employee) {
        Employee existingEmployee = service.getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        
        service.saveEmployee(existingEmployee);
        return "redirect:/employees";
    }

    // Delete employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return "redirect:/employees";
    }
}
