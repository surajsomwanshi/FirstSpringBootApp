package com.codewithsuraj.SpringBootApp.service;

import com.codewithsuraj.SpringBootApp.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeId(String id);

    String deleteEmployeeById(String id);
}
