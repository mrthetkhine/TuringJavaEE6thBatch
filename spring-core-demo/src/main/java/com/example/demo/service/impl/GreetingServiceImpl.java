package com.example.demo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.PrototypeScopeBean;
import com.example.demo.service.GreetingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GreetingServiceImpl implements GreetingService{

	@Autowired
	PrototypeScopeBean protoBean;
	
	public GreetingServiceImpl()
	{
		log.info("GreetingServiceImpl created");
	}
	
	@Override
	public String greet() {
		//this.protoBean.toString();
		return this.protoBean.toString()+"Hello from Spring GrettingService ref-> "+ this;
	}

}
