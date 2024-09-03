package com.javaee6.webmvc.demo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaee6.webmvc.demo.model.Address;
import com.javaee6.webmvc.demo.model.dto.BookDto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/view-demo")
public class ViewDemoController {

	@ExceptionHandler(RuntimeException.class)
	String erorr(HttpServletRequest req,RuntimeException ex)
	{
		log.info("Error at "+req.getRequestURL());
		log.info("Exception happened in view-demo controller "+ex.getMessage());
		return "/view-demo/error.html";
	}
	@GetMapping
	String viewDemo(Model model)
	{
		model.addAttribute("message", "Hello from thymeleaf");
		model.addAttribute("admin", false);
		return "/view-demo/demo";
	}
	@GetMapping(value="/problem")
	String problemMethod(Model model)
	{
		throw new RuntimeException("Something happened in controller");
		//return "/view-demo/demo";
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

	@GetMapping(value="/address")
	String newAddress(Model model)
	{
		Address address = new Address();
		model.addAttribute("address",address);

		List<String> cities = new ArrayList<>();
		cities.add("Yangon");
		cities.add("Mandalay");
		cities.add("NayPyiTaw");

		model.addAttribute("cities",cities);
		return "/view-demo/address";
	}
	@PostMapping(value="/address")
	String saveAddress(Model model,@ModelAttribute Address addressDto)
	{
		log.info("Save address City "+addressDto.getCity());
		Address address = new Address();
		model.addAttribute("address",address);

		List<String> cities = new ArrayList<>();
		cities.add("Yangon");
		cities.add("Mandalay");
		cities.add("NayPyiTaw");

		model.addAttribute("cities",cities);
		return "/view-demo/address";
	}
}
