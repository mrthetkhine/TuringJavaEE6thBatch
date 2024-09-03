package com.javaee6.webmvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaee6.webmvc.demo.model.dto.BookDto;
import com.javaee6.webmvc.demo.service.BookService;

import jakarta.servlet.ServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/example")
public class ExampleController {
	@Autowired
	BookService bookService;

	@GetMapping(value="api")
	@ResponseBody
	List<BookDto> getAllBooksApi(ServletRequest request,
								@RequestHeader("Host") String host)
	{
		log.info("API "+host);
		List<BookDto> books = this.bookService.getAllBook();
		return books;
	}


	@GetMapping(value="api/{bookId}")
	@ResponseBody
	BookDto getBookById(@PathVariable Integer bookId)
	{
		List<BookDto> books = this.bookService.getAllBook();
		return books.get(bookId);
	}

	@GetMapping(value="search")
	@ResponseBody
	List<BookDto> searchApi(@RequestParam String query)
	{
		log.info("API "+query);
		List<BookDto> books = this.bookService.getAllBook();
		return books;
	}
}
