package com.example.demo.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.service.GreetingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GreetingServiceImpl implements GreetingService{

	public GreetingServiceImpl()
	{
		log.info("GreetingServiceImpl created");
	}
	
	@Override
	public String greet() {
		
		return "Hello from Spring GrettingService ref-> "+ this;
	}

}
