package com.javaee6.webmvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaee6.webmvc.demo.model.BookDto;
import com.javaee6.webmvc.demo.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	String getAllBook(Model model)
	{
		List<BookDto> books = this.bookService.getAllBook();
		log.info("books.length ",books.size());
		model.addAttribute("books", books);
		
		return "books/book.html";
	}
}
