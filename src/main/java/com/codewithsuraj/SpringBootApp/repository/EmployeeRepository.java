package com.codewithsuraj.SpringBootApp.repository;

import com.codewithsuraj.SpringBootApp.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,String> {

}
