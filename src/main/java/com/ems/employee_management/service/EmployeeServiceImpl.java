package com.ems.employee_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.employee_management.entity.Employee;
import com.ems.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    // Constructor Injection
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Create Employee
    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Get All Employees
    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Get Employee by ID
    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    // Update Employee
    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = getEmployeeById(id);

        existing.setFirstName(employee.getFirstName());
        existing.setLastName(employee.getLastName());
        existing.setEmail(employee.getEmail());

        return repository.save(existing);
    }

    // Delete Employee
    @Override
    public void deleteEmployee(Long id) {
        Employee existing = getEmployeeById(id);
        repository.delete(existing);
    }
}