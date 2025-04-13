package com.springbootRestAPI.emsCurdDatabase.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.springbootRestAPI.emsCurdDatabase.Mapper.employeeMapper;
import com.springbootRestAPI.emsCurdDatabase.daoRepository.employeeRepository;
import com.springbootRestAPI.emsCurdDatabase.dto.employeeDto;
import com.springbootRestAPI.emsCurdDatabase.entity.Employee;
import com.springbootRestAPI.emsCurdDatabase.exception.resourceNotFoundException;
import com.springbootRestAPI.emsCurdDatabase.service.employeeService;

import lombok.AllArgsConstructor;

@Service // tells the spring contianer to create the spring beam for employeeServiceImpl
         // class.
@AllArgsConstructor
public class employeeServiceImpl implements employeeService {
    // Injecting the dependencies
  
    private employeeRepository EmployeeRepository;// Constructor based injection dependency to inject the dependency
    @Override
    public employeeDto createEmployee(employeeDto EmployeeDto) {
        Employee employee = employeeMapper.mapEmployee(EmployeeDto);
        // save the employee entity into the database
        EmployeeRepository.save(employee);
        return employeeMapper.mapEmployeeDto(employee);
    }
    @Override
    public employeeDto getEmployeeById(Long employeeId) {
        Employee employee= EmployeeRepository.findById(employeeId)
        .orElseThrow(()->
         new resourceNotFoundException("Employee not exists with given id:"+employeeId));
         return employeeMapper.mapEmployeeDto(employee);
    }
    @Override
    public List<employeeDto> getAllEmployees(){
        List<Employee> Employees= EmployeeRepository.findAll();
        return Employees.stream().map((employee) -> employeeMapper.mapEmployeeDto(employee))
        .collect(Collectors.toList());
    }
    @Override
    public employeeDto updateEmployee(Long employeeId, employeeDto EmployeeDto) {
        Employee employee= EmployeeRepository.findById(employeeId)
        .orElseThrow(()->
         new resourceNotFoundException("Employee not exists with given id:"+employeeId));

         employee.setFirstName(EmployeeDto.getFirstName());
         employee.setLastName(EmployeeDto.getLastName());
         employee.setEmail(EmployeeDto.getEmail());
         EmployeeRepository.save(employee); // save perform both operations of creation and updation (in case of already existing of employeeId)
         return employeeMapper.mapEmployeeDto(employee);

        // or 
        // Employee employee = employeeMapper.mapEmployee(EmployeeDto);
        // employee.setId(employeeId);
        // EmployeeRepository.save(employee);
        // return employeeMapper.mapEmployeeDto(employee);
    }
    @Override
    public void deleteEmployee(Long employeeId) {
        EmployeeRepository.findById(employeeId)
        .orElseThrow(()->
         new resourceNotFoundException("Employee not exists with given id:"+employeeId));
        EmployeeRepository.deleteById(employeeId);
        }

}
