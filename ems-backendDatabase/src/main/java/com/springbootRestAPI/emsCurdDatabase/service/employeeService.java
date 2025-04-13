package com.springbootRestAPI.emsCurdDatabase.service;
// 1. Create the service layer employeeServie and employeeServiceImpl.
// 2. Build Add Employee REST API in controller package/layer
// 3. Test Add Employee REST API using postman client.

import java.util.List;

import com.springbootRestAPI.emsCurdDatabase.dto.employeeDto;

public interface employeeService {

    employeeDto createEmployee(employeeDto EmployeeDto);
    employeeDto getEmployeeById(Long employeeId);
    List<employeeDto> getAllEmployees();
    employeeDto updateEmployee(Long employeeId, employeeDto EmployeeDto);
    void deleteEmployee(Long employeeId);
}
