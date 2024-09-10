package com.javaee6.webmvc.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaee6.webmvc.demo.common.Mapper;
import com.javaee6.webmvc.demo.dao.BookDao;
import com.javaee6.webmvc.demo.model.Book;
import com.javaee6.webmvc.demo.model.dto.BookDto;
import com.javaee6.webmvc.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDao bookDao;
	
	//ModelMapper modelMapper = new ModelMapper();
	@Autowired
	Mapper mapper;
	
	

	BookServiceImpl()
	{
		
	}
	@Override
	public List<BookDto> getAllBook() {

		List<Book> books = this.bookDao.getAllBook();
		List<BookDto> bookList = mapper.mapList(books, BookDto.class);
		return bookList;
	}
	
	
	@Override
	public BookDto addBook(BookDto bookDto) {
		Book book = this.bookDao.saveBook(bookDto);
		BookDto dto = this.mapper.getMapper().map(book, BookDto.class);
		
		return dto;
	}
	@Override
	public Optional<BookDto> getBookById(Long bookId) {

		Optional<Book> book = this.bookDao.getBookById(bookId);
		if(book.isPresent())
		{
			BookDto dto = this.mapper.getMapper().map(book.get(), BookDto.class);
			return Optional.of(dto);
		}
		else
		{
			return Optional.empty();
		}
		
	}
	@Override
	public BookDto updateBook(BookDto bookDto) {
		Book updatedBook = this.bookDao.updateBook(bookDto);
		BookDto dto = this.mapper.map(updatedBook, BookDto.class);
		return dto;
	}
	@Override
	public BookDto deleteBook(BookDto bookDto) {
		Book book =  this.bookDao.deleteBookById(bookDto.getId());
		BookDto dto = this.mapper.map(book, BookDto.class);
		return dto;
	}


}
