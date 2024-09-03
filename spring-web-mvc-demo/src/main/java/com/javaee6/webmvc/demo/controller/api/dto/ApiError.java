package com.javaee6.webmvc.demo.controller.api.dto;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {
	private HttpStatus status;
	private String errorCode;
    private String message;
    private List<String> errors;

    public ApiError(HttpStatus status, String errorCode, String message, List<String> errors) {
        super();
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String errorCode, String message, String error) {
        super();
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
        errors = Arrays.asList(error);
    }
}
