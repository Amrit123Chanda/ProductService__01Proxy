package com.example.productservice_proxy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleException(Exception e)
    {
        return new ResponseEntity<>("Exception raised", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
