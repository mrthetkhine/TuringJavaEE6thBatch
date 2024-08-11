package com.javaee6.webmvc.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javaee6.webmvc.demo.model.BookDto;
import com.javaee6.webmvc.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	List<BookDto> books = new ArrayList<>();
	
	BookServiceImpl()
	{
		this.books.add(new BookDto(1L,"Title1 ","Author 1","Description1"));
		this.books.add(new BookDto(2L,"Title 2 ","Author 2","Description 2"));
	}
	@Override
	public List<BookDto> getAllBook() {
		
		return this.books;
	}

}
