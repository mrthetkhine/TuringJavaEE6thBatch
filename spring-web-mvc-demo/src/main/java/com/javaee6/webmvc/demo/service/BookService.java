package com.javaee6.webmvc.demo.service;
import java.util.List;
import java.util.Optional;

import com.javaee6.webmvc.demo.model.dto.BookDto;

public interface BookService {
	List<BookDto> getAllBook();
	BookDto addBook(BookDto book);
	Optional<BookDto> getBookById(Long bookId);
	BookDto updateBook(BookDto book);
	BookDto deleteBook(BookDto book);
}
