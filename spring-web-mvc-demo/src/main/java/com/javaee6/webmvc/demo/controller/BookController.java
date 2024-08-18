package com.javaee6.webmvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaee6.webmvc.demo.model.BookDto;
import com.javaee6.webmvc.demo.service.BookService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping(value="new")
	String newBook(Model model)
	{
		log.info("GET new book");
		BookDto book = new BookDto();
		//book.setTitle("Dummy Title");
		model.addAttribute("book", book);
		return "books/new.html";
	}
	@PostMapping(value="new")
	String saveBook(@Valid @ModelAttribute("book") BookDto book,BindingResult bindingResult,Model model)
	{
		log.info("POST book");
		if(bindingResult.hasErrors())
		{
			log.info("Got erorr in saving book",bindingResult.getAllErrors());
			/*
			for(ObjectError error : bindingResult.getAllErrors())
			{
				log.info("Error {}  Message {}",error.getObjectName() ,error.getDefaultMessage());
			}
			*/
			return "books/new.html";
		}
		else
		{
			log.info("Save book "+book);
			this.bookService.addBook(book);
			model.addAttribute("newBookSaved", "New Book have been saved");
			model.addAttribute("book", new BookDto());
			return "/books/new.html";
		}
		
	}
	@GetMapping
	String getAllBook(Model model)
	{
		List<BookDto> books = this.bookService.getAllBook();
		log.info("books.length ",books.size());
		model.addAttribute("books", books);
		
		return "books/book.html";
	}
}
