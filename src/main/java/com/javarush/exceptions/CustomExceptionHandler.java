package com.javarush.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserNotValidExceptions.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User not valid")
    public void handleUserNotValidExceptions(Exception e) {
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException e) {
        StringBuilder errorBuilder = new StringBuilder();
        errorBuilder.append("Errors: ").append("\n");
        e.getBindingResult().getAllErrors().forEach(error ->
        {
            errorBuilder.append(error.getDefaultMessage()).append("\n");
        });
        return new ResponseEntity<>(errorBuilder.toString(), HttpStatus.BAD_REQUEST);
    }
}
