package com.javaee6.webmvc.demo.service;
import java.util.List;

import com.javaee6.webmvc.demo.model.BookDto;

public interface BookService {
	List<BookDto> getAllBook();
	void addBook(BookDto book);
}
