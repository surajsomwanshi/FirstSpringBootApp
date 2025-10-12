package com.codewithsuraj.SpringBootApp.service;

import com.codewithsuraj.SpringBootApp.entity.EmployeeEntity;
import com.codewithsuraj.SpringBootApp.model.Employee;
import com.codewithsuraj.SpringBootApp.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmpId() == null ||
                employee.getEmailId().isEmpty()){
            employee.setEmpId(UUID.randomUUID().toString());
        }

        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,entity);
        employeeRepository.save(entity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        List<Employee> employees
                = employeeEntityList
                .stream()
                .map(employeeEntity -> {
                    Employee employee = new Employee();
                    BeanUtils.copyProperties(employeeEntity,employee);
                    return employee;
                })
                .collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee getEmployeeId(String id) {
        EmployeeEntity employeeEntity
                = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
        return "Employee deleted with the id:"+ id;
    }
}
