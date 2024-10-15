package com.javaee6.webmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class AuthController {

	
	
	@GetMapping("/login")
	String login()
	{
		log.info("login controller");
		return "login";
	}
	@GetMapping("/logout")
	String logout()
	{
		log.info("logout controller");
		return "logout";
	}
	@GetMapping("/403")
	String accessDenied()
	{
		log.info("accessDenied controller");
		return "403";
	}
}
