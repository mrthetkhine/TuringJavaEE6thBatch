package com.javaee6.webmvc.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javaee6.webmvc.demo.model.dto.BookDto;
import com.javaee6.webmvc.demo.service.BookService;
import com.javaee6.webmvc.demo.validator.BookValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	//@Qualifier("bookDtoValidator")
	BookValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@GetMapping
	String getAllBook(Model model)
	{
		List<BookDto> books = this.bookService.getAllBook();
		log.info("books.length ",books.size());
		model.addAttribute("books", books);

		return "books/book.html";
	}

	@GetMapping(value="new")
	ModelAndView newBook(Model model)
	{
		log.info("GET new book");
		BookDto book = new BookDto();
		//book.setTitle("Dummy Title");
		model.addAttribute("book", book);
		return new ModelAndView("books/new.html");
	}

	/*
	@PostMapping(value="new")
	String saveBook(@Valid @ModelAttribute("book") BookDto book,BindingResult bindingResult,Model model)
	{
		log.info("POST book");
		if(bindingResult.hasErrors())
		{
			log.info("Got erorr in saving book",bindingResult.getAllErrors());

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

	}*/
	@PostMapping(value="new")
	String saveBook(@ModelAttribute("book") @Validated BookDto book,BindingResult bindingResult,Model model)
	{
		log.info("POST book");
		//bindingResult.reject("errorCode");
		if(bindingResult.hasErrors())
		{
			log.info("Got erorr in saving book",bindingResult.getAllErrors());
			/*
			for(ObjectError error : bindingResult.getAllErrors())
			{
				log.info("Error {} {}",error.getDefaultMessage(),error.getCode());
			}*/
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


	@GetMapping(value="edit/{bookId}")
	String editBook(Model model,@PathVariable Long bookId)
	{
		log.info("edit book "+bookId);
		Optional<BookDto> result = this.bookService.getBookById(bookId);
		//book.setTitle("Dummy Title");
		if(result.isPresent())
		{
			model.addAttribute("book", result.get());
			model.addAttribute("edit", true);
			return "books/new.html";
		}
		else
		{
			return "books/not-found.html";
		}

	}

	@PostMapping(value="edit")
	String updateBook(@ModelAttribute("book") @Validated BookDto book,BindingResult bindingResult,Model model)
	{
		log.info("update book "+model);
		if(bindingResult.hasErrors())
		{
			log.info("Got erorr in upadting book",bindingResult.getAllErrors());
			model.addAttribute("edit", true);
			return "books/new.html";
		}
		else
		{
			this.bookService.updateBook(book);
			return "redirect:/books";

		}


	}
	@GetMapping(value="delete/{bookId}")
	String deleteBook(Model model,@PathVariable Long bookId)
	{
		log.info("edit book "+bookId);
		Optional<BookDto> result = this.bookService.getBookById(bookId);
		//book.setTitle("Dummy Title");
		if(result.isPresent())
		{
			this.bookService.deleteBook(result.get());
			return "redirect:/books";
		}
		else
		{
			return "books/not-found.html";
		}

	}
}
