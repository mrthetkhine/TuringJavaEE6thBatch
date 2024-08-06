package com.example.demo.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ExampleBean;
import com.example.demo.bean.HelloMessageGenerator;
import com.example.demo.bean.PrototypeScopeBean;
import com.example.demo.config.AppConfig;
import com.example.demo.service.GreetingService;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/core")
public class CoreController {

	@Autowired
	ExampleBean exampleBean;
	
	@Autowired
	GreetingService greetingService;
	
	@Resource(name = "requestScopedBean")
    HelloMessageGenerator requestScopedBean;
	
	@GetMapping("/bean-test")
	String beanTest()
	{
		
		return this.exampleBean.api() + this.greetingService.greet();
	}
	@GetMapping("/request")
	String reqeust()
	{
		
		log.info("requestScopedBean "+requestScopedBean);
		return this.requestScopedBean.getMessage();
	}
}
