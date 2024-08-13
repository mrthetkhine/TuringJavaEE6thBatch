package com.javaee6.webmvc.demo.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaee6.webmvc.demo.model.BookDto;

@Controller
@RequestMapping("/view-demo")
public class ViewDemoController {

	@GetMapping
	String viewDemo(Model model)
	{
		model.addAttribute("message", "Hello from thymeleaf");
		model.addAttribute("admin", false);
		return "/view-demo/demo";
	}
	
	@GetMapping(value="/another")
	String another(Model model)
	{
		//model.addAttribute("message", "Hello from thymeleaf");
		model.addAttribute("today",Calendar.getInstance());
		return "/view-demo/demo";
	}
	@GetMapping(value="/book")
	String demoObject(Model model)
	{
		//model.addAttribute("message", "Hello from thymeleaf");
		BookDto bookDto = new BookDto(1L,"How to win friend & influence people ","Dale Carnegie","Description1");
		model.addAttribute("book", bookDto);
		return "/view-demo/book";
	}
}
