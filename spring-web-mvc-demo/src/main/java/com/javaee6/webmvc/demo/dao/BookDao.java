package com.javaee6.webmvc.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaee6.webmvc.demo.model.Book;

import com.javaee6.webmvc.demo.model.dto.*;


public interface BookDao {
	List<Book> getAllBook();
	Optional<Book> getBookById(Long bookId);
	Book saveBook(BookDto bookDto);
	Book updateBook(BookDto bookDto);
	Book deleteBookById(Long bookId);
}
