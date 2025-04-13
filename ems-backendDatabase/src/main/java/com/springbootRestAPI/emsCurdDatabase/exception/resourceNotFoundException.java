package com.springbootRestAPI.emsCurdDatabase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) //404 
public class resourceNotFoundException extends RuntimeException{
    public resourceNotFoundException(String message){
        super(message);
    }
}
