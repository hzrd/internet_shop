/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.mavenproject6.exceptions;

import java.io.IOException;
import java.sql.SQLException;
 
import javax.servlet.http.HttpServletRequest;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
 
@ControllerAdvice
public class GlobalExceptionHandler {
 
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleIOException(HttpServletRequest request, Exception ex){
        System.err.println("step 1");
        logger.error("IOException handler executed");
        return new ModelAndView("thy/403");
    }
    
    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView handleIOException2(HttpServletRequest request, Exception ex){
        System.err.println("step 5");
        logger.error("IOException handler executed");
        return new ModelAndView("thy/exception");
    }
}
