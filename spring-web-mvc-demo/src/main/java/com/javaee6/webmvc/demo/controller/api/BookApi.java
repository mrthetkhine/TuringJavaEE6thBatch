package com.javaee6.webmvc.demo.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaee6.webmvc.demo.controller.api.exception.BookNotFoundException;
import com.javaee6.webmvc.demo.controller.api.exception.BeanValidationException;
import com.javaee6.webmvc.demo.model.dto.BookDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RequestMapping("/api/books")
public interface BookApi {
	@GetMapping
	List<BookDto> getAllBook();
	
	@Operation(summary = "Get a book by its id")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Found the book", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = BookDto.class)) }),
			  @ApiResponse(responseCode = "400", description = "Invalid id supplied", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Book not found", 
			    content = @Content) })
	@GetMapping(value = "/{bookId}")
	ResponseEntity<BookDto> getBookById(@PathVariable Long bookId) throws BookNotFoundException ;
	
	@PostMapping
	ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookdDto, BindingResult result)throws BeanValidationException;
	
	@PutMapping(value = "/{bookId}")
	ResponseEntity<BookDto> updateBookById(@PathVariable Long bookId,@Valid @RequestBody BookDto bookdDto,BindingResult result) throws BookNotFoundException,BeanValidationException ;
	
	@DeleteMapping(value = "/{bookId}")
	ResponseEntity<BookDto> deleteBookById(@PathVariable Long bookId) throws BookNotFoundException ;
}
