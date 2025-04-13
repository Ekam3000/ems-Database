package com.springbootRestAPI.emsCurdDatabase.Mapper;

import com.springbootRestAPI.emsCurdDatabase.dto.employeeDto;
import com.springbootRestAPI.emsCurdDatabase.entity.Employee;

//when we build restAPIs, in order to map employeeDto to employeeEntity and vice versa we use employeeMapper class
public class employeeMapper {

    public static employeeDto mapEmployeeDto(Employee employee)
    {
        return new employeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );
    }
    public static Employee mapEmployee(employeeDto employeedto)
    {
        return new Employee(
            employeedto.getId(),
            employeedto.getFirstName(),
            employeedto.getLastName(),
            employeedto.getEmail()
        );
    }
}
