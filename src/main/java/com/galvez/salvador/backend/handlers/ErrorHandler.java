package com.galvez.salvador.backend.handlers;

import com.galvez.salvador.backend.exceptions.ResourceNotFoundException;
import com.galvez.salvador.backend.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        int code = HttpStatus.NOT_FOUND.value();
        ErrorResponse error = new ErrorResponse();
        error.setError("La tarea no existe.");
        error.setMessage(ex.getMessage());
        error.setStatus(code);
        return ResponseEntity.status(code).body(error);
    }
}
