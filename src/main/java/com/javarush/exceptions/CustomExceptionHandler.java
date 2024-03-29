package com.javarush.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserNotValidExceptions.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User not valid")
    public void handleUserNotValidExceptions(Exception e) {

    }
}
