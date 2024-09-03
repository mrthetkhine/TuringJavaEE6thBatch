package com.javaee6.webmvc.demo.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaee6.webmvc.demo.controller.api.exception.BookNotFoundException;
import com.javaee6.webmvc.demo.model.dto.BookDto;
import com.javaee6.webmvc.demo.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookApiConroller {

	@Autowired
	BookService bookService;

	@GetMapping
	List<BookDto> getAllBook() {
		log.info("/api/books controller");
		return this.bookService.getAllBook();
	}

	@GetMapping(value = "/{bookId}")
	ResponseEntity<BookDto> getBookById(@PathVariable Long bookId) throws BookNotFoundException {
		Optional<BookDto> result = this.bookService.getBookById(bookId);
		if (!result.isEmpty()) 
		{
			return ResponseEntity.ok(result.get());
		} 
		else 
		{
			throw new BookNotFoundException("Book " + bookId + " not found");
		}

	}
}
