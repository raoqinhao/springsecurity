package com.hh.springsecurity.controller;

import com.hh.springsecurity.exception.NotFoundUserNameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = NotFoundUserNameException.class)
    @ResponseBody
    public String notFoundUserNameHandler(NotFoundUserNameException e) {
        e.printStackTrace();
        String message = e.getMessage();
        return message;
    }

}
