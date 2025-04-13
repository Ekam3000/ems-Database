package com.springbootRestAPI.emsCurdDatabase.daoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootRestAPI.emsCurdDatabase.entity.Employee;

// Once employeeRepository extends JpaRepository, then this
//employeeRepository will get core methods to perform on Employee
//entity

@Repository
public interface employeeRepository extends JpaRepository<Employee, Long> {
}