package com.ems.employee_management.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.ems.employee_management.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}