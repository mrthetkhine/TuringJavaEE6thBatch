package com.javaee6.webmvc.demo.controller.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GloabalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	  public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	    log.info("Gloablerorr at "+req.getRequestURL());
	    log.info("exception {} ",e.getMessage());
	    return "globalError";
	  }
	@ExceptionHandler(value = NoResourceFoundException.class)
	  public String noResourceFoundExcpetion(HttpServletRequest req, Exception e) throws Exception {
	    log.info("noResourceFoundExcpetion at "+req.getRequestURL());
	    log.info("exception {} ",e.getMessage());
	    return "globalError";
	 }
}
