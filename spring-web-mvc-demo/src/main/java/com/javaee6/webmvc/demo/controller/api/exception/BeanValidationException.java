package com.javaee6.webmvc.demo.controller.api.exception;

import java.util.List;

import org.springframework.validation.ObjectError;

import lombok.Data;

@Data
public class BeanValidationException extends Exception{
	List<ObjectError> errors;
	public BeanValidationException(List<ObjectError> errors)
	{
		this.errors = errors;
	}
}
