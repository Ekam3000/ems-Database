package com.springbootRestAPI.emsCurdDatabase.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// we built employeeDto class to transfer the data between client and the employee. when we will build the restAPIs services we will use this employeeDTo as a response for this restAPIs
public class employeeDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
