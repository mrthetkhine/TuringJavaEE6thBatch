package com.javaee6.webmvc.demo.controller.api.exception;

public class BookNotFoundException extends Exception{
	public BookNotFoundException(String message)
	{
		super(message);
	}
}
