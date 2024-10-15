package com.javaee6.webmvc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaee6.webmvc.demo.model.dto.BookDto;
import com.javaee6.webmvc.demo.model.dto.UserDto;
import com.javaee6.webmvc.demo.service.UserRegisterationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	@Autowired
	UserRegisterationService userRegisterationService;
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/register")
	String register(Model model) 
	{
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//log.info("Auth user name " +authentication.getName());
		//authentication.getAuthorities().forEach(auth->log.info("Role "+ auth.getAuthority()));
		log.info("register controller");
		//throw new Exception("Custom exception");
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}
	@PostMapping("/register")
	String saveRegistedUser(@ModelAttribute("user") @Validated UserDto userDto,BindingResult bindingResult,Model model) 
	{
		
		if(bindingResult.hasErrors())
		{
			return "register";
		}
		else
		{
			log.info("Save user "+ userDto.getUsername() );
			try {
				this.userRegisterationService.registerUser(userDto);
				
			} catch (Exception e) {
				model.addAttribute("message", "User already existed");
				model.addAttribute("user", new UserDto());
				return "register";
			}
			model.addAttribute("message", "New User have been registered");
			model.addAttribute("user", new UserDto());
			return "/register";
		}
		
	}
	 
}
