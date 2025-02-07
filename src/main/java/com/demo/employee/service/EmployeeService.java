package com.demo.employee.service;

import com.demo.employee.model.Employee;
import com.demo.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}
