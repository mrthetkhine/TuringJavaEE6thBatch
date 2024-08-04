package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.GreetingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/")
public class HelloWorldController {

	int count = 0;
	
	@Autowired
	GreetingService greetService;
	
	/*
	public HelloWorldController(GreetingService greetService)
	{
		log.info("HelloWorldController created");
		this.greetService = greetService;
	}*/
	
	public HelloWorldController()
	{
		log.info("HelloWorldController created");
		
	}
	/*
	//setter based
	public void setGreetService(GreetingService greetService)
	{
		this.greetService = greetService;
	}*/
	
	@GetMapping("/hello")
	String hello()
	{
		log.info("Controller instance "+this);
		count++;
		return greetService.greet()+ " Count "+count;
	}
}
