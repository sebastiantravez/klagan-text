package com.klagan.text.exceptions.handler;

import com.klagan.product.exception.ProductException;
import com.klagan.text.exceptions.ExceptionResponse;
import com.klagan.text.exceptions.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ExceptionResponse> customExceptionHandler(GenericException exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().mensaje(exception.getMessage()).build();
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<>(exceptionResponse, exception.getStatus());
        return response;
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ExceptionResponse> productExceptionHandler(ProductException exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().mensaje(exception.getMessage()).build();
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }

}
