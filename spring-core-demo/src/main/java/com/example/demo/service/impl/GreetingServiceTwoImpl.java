package com.example.demo.service.impl;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.service.GreetingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class GreetingServiceTwoImpl implements GreetingService{

	public GreetingServiceTwoImpl()
	{
		log.info("GreetingServiceImpl created");
	}
	
	@Override
	public String greet() {
		
		return "Hello from Spring "+new Date();
	}

}
