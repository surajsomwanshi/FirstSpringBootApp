package com.codewithsuraj.SpringBootApp.service;

import com.codewithsuraj.SpringBootApp.exception.EmployeeNotFoundException;
import com.codewithsuraj.SpringBootApp.model.Employee;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmpId() == null ||
        employee.getEmailId().isEmpty()){
            employee.setEmpId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeId(String id) {
        return employees.stream()
                .filter(employee -> employee.getEmpId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("" +
                        "Employee not found with Id: "+ id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee = employees.stream()
                .filter(emp -> emp.getEmpId().equalsIgnoreCase(id))
                .findFirst()
                .get();
        employees.remove(employee);
        return "Employee deleted with the id: "+ id;
    }
}
