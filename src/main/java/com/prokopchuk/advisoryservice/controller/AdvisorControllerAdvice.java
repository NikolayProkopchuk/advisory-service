package com.prokopchuk.advisoryservice.controller;

import com.prokopchuk.advisoryservice.exception.AdvisoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdvisorControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<String> handleAdvisorNotFoundException(AdvisoryException ex) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }
}
