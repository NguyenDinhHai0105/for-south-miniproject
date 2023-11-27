package com.example.demo.controller;

import com.example.demo.exception.CustomExceptionResponse;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler
    public ResponseEntity<CustomExceptionResponse> handleException(ResourceNotFoundException exception) {
        CustomExceptionResponse error = new CustomExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomExceptionResponse> handleGenericException(Exception e) {
        CustomExceptionResponse error = new CustomExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
