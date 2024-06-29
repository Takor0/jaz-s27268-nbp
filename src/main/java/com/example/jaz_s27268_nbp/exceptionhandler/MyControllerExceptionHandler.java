package com.example.jaz_s27268_nbp.exceptionhandler;

import com.example.jaz_s27268_nbp.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class MyControllerExceptionHandler {

    @ExceptionHandler({NoRatesException.class})
    public ResponseEntity<String> handleNoRatesException(NoRatesException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler({HttpClientErrorException.class})
    public ResponseEntity<String> handleHttpClientErrorException(HttpClientErrorException ex) {
        if (ex.getStatusCode() == HttpStatus.NOT_FOUND) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        if (ex.getStatusCode() == HttpStatus.BAD_REQUEST) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }


}