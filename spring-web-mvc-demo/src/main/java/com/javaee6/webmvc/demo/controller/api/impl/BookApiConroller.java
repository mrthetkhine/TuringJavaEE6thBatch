package com.javaee6.webmvc.demo.controller.api.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.javaee6.webmvc.demo.controller.api.BookApi;
import com.javaee6.webmvc.demo.controller.api.exception.BeanValidationException;
import com.javaee6.webmvc.demo.controller.api.exception.BookNotFoundException;

import com.javaee6.webmvc.demo.model.dto.BookDto;
import com.javaee6.webmvc.demo.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BookApiConroller implements BookApi {

	@Autowired
	BookService bookService;

	public List<BookDto> getAllBook() {
		log.info("/api/books controller");
		return this.bookService.getAllBook();
	}
	
	public ResponseEntity<BookDto> getBookById(@PathVariable Long bookId) throws BookNotFoundException {
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

	@Override
	public ResponseEntity<BookDto> createBook( BookDto bookdDto,BindingResult bindingResult)throws BeanValidationException {
		log.info("binding result "+bindingResult.hasErrors() );
		if(!bindingResult.hasErrors())
		{
			BookDto insertedBook = this.bookService.addBook(bookdDto);
			return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(insertedBook);
		}
		else
		{
			//custom error
			throw new BeanValidationException(bindingResult.getAllErrors());
		}
	}

	@Override
	public ResponseEntity<BookDto> updateBookById(Long bookId,
													@Valid @RequestBody BookDto bookDto,
													BindingResult bindingResult) 
															throws BookNotFoundException, BeanValidationException {
		if(!bindingResult.hasErrors())
		{
			Optional<BookDto> book = this.bookService.getBookById(bookId);
			
			if(book.isPresent())
			{
				BookDto dto =  this.bookService.updateBook(bookDto);
				return ResponseEntity.of(Optional.of(dto));
			}
			else
			{
				throw new BookNotFoundException("Book " + bookId + " not found");
			}
		}
		else
		{
			//custom error
			throw new BeanValidationException(bindingResult.getAllErrors());
		}
	}

	@Override
	public ResponseEntity<BookDto> deleteBookById(Long bookId) throws BookNotFoundException {
		Optional<BookDto> book = this.bookService.getBookById(bookId);
		if(book.isPresent())
		{
			BookDto deletedBook = this.bookService.deleteBook(book.get());
			return ResponseEntity.of(Optional.of(deletedBook));
		}
		else
		{
			throw new BookNotFoundException("Book " + bookId + " not found");
		}
		
	}
}
