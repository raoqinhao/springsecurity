package com.hh.springsecurity.controller;

import com.hh.springsecurity.exception.NotFoundUserNameException;
import com.hh.springsecurity.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandlerController.class);

    @ExceptionHandler(value = NotFoundUserNameException.class)
    @ResponseBody
    public String notFoundUserNameHandler(NotFoundUserNameException e) {
        e.printStackTrace();
        return ExceptionUtils.pushMessage("404",e.getMessage());
    }

}
