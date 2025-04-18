package com.springbootRestAPI.emsCurdDatabase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootRestAPI.emsCurdDatabase.dto.employeeDto;
import com.springbootRestAPI.emsCurdDatabase.service.employeeService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("*")
@AllArgsConstructor
@RestController // this class will be able to handle HTTP Requests
// To define the base URL for all rest apis that we are going to build within
// this controller we use RequestMapping

@RequestMapping("/api/employees")
public class employeeController {
    private final employeeService EmployeeService;

    // Built Add Employee REST Api
    @PostMapping
    public ResponseEntity<employeeDto> createEmployee(@RequestBody employeeDto EmployeeDto)
    // RequestBody will extract the json from the HTTP Request and convert the json
    // into EmployeeDto
    // The json should have the same names of key which are used for employeedto
    // class
    {
        employeeDto savedEmployee = null;
        try {
            savedEmployee = EmployeeService.createEmployee(EmployeeDto);
            System.out.println(savedEmployee);
            return ResponseEntity.of(Optional.of(savedEmployee));// 200 // no new object Created
            // return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);// 200 status
            // // new object created and returned
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 status
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<employeeDto> getEmployeeById(@PathVariable("id") Long employeeId) { // binding id with employeeId with help of @PathVariable       
        employeeDto employee = null;
        employee = EmployeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employee); // 200 status
    }

    // Build Get all Employees REST API
    @GetMapping()
    public ResponseEntity<?> getAllEmployees() {
        List<employeeDto> employees = EmployeeService.getAllEmployees();
        if (employees.isEmpty()) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "No employees found");
        return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(employees);// 200 status
        // List<employeeDto> employees = EmployeeService.getAllEmployees();
        // return ResponseEntity.ok(employees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<employeeDto> updateEmployee(@PathVariable("id") Long employeeId,
            @RequestBody employeeDto EmployeeDto) {

        employeeDto updatedEmployee = EmployeeService.updateEmployee(employeeId, EmployeeDto);

        // return ResponseEntity.ok().body(updatedEmployee);
        return ResponseEntity.of(Optional.of(updatedEmployee)); // 200

        // catch (Exception e) { //if catch block is present then in case of exception this catch block will run. No printing of message "Employee not exists with given id:"+employeeId from the employeeServiceImpl class. but in absence of catch bock 'resourceNotFoundException' class will run and will desplay msg along with 404 status.
        // e.printStackTrace();
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        // }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee( @PathVariable("id") Long employeeId){
        
            EmployeeService.deleteEmployee(employeeId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 status
        
        // catch(Exception e){  //if catch block is present then in case of exception this catch block will run. No printing of message "Employee not exists with given id:"+employeeId from the employeeServiceImpl class. but in absence of catch bock 'resourceNotFoundException' class will run and will desplay msg along with 404 status.
        //     e.printStackTrace();
        //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        // }
    }
}
