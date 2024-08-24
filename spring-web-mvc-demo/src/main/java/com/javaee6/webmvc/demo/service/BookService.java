package com.javaee6.webmvc.demo.service;
import java.util.List;
import java.util.Optional;

import com.javaee6.webmvc.demo.model.BookDto;

public interface BookService {
	List<BookDto> getAllBook();
	void addBook(BookDto book);
	Optional<BookDto> getBookById(Long bookId);
	void updateBook(BookDto book);
}
