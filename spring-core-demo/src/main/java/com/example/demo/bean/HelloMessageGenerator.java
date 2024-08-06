package com.example.demo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;


public class HelloMessageGenerator {
	String message="Default Message";
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getMessage()
	{
		return this.message;
	}
}
