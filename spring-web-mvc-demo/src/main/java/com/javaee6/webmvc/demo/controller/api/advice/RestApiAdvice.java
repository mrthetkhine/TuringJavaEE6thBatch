package com.javaee6.webmvc.demo.controller.api.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;

import com.javaee6.webmvc.demo.controller.api.dto.ApiError;
import com.javaee6.webmvc.demo.controller.api.dto.ErrorCode;
import com.javaee6.webmvc.demo.controller.api.exception.*;
import com.javaee6.webmvc.demo.controller.api.impl.BookApiConroller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class RestApiAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
	  MethodArgumentTypeMismatchException ex, WebRequest request) {
		
		log.info("handleMethodArgumentTypeMismatch");
	    String error = 
	      ex.getName() + " should be of type " + ex.getRequiredType().getName();

	    ApiError apiError = 
	      new ApiError(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_PARAMETER_TYPE.toString(), ex.getLocalizedMessage(), error);
	    return new ResponseEntity<Object>(
	      apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	  @ExceptionHandler(BookNotFoundException.class)
	  public ResponseEntity<Object> handleBookNotFound(BookNotFoundException ex, WebRequest request) 
	  {
				
			log.info("handleBookNotFound");
		    String error = ex.getMessage(); 
	
		    ApiError apiError = 
		      new ApiError(HttpStatus.NOT_FOUND, ErrorCode.INVALID_BOOK_ID_TYPE.toString(), ex.getLocalizedMessage(), error);
		    return new ResponseEntity<Object>(
		      apiError, new HttpHeaders(), apiError.getStatus());
	}
	  @ExceptionHandler(BeanValidationException.class)
	  public ResponseEntity<Object> handleValidationException(BeanValidationException ex, WebRequest request) 
	  {
				
			log.info("BeanValidationException");
		    List<String> errorMessage =new ArrayList<String>();
		    for (ObjectError error : ex.getErrors())
		    {
		    	errorMessage.add(error.getDefaultMessage());
		    }
	
		    ApiError apiError = 
		      new ApiError(HttpStatus.BAD_REQUEST, ErrorCode.BEAN_VALIDATION_ERROR.toString(), ex.getLocalizedMessage(), errorMessage);
		    return new ResponseEntity<Object>(
		      apiError, new HttpHeaders(), apiError.getStatus());
	}
}
