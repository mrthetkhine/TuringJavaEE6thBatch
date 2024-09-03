package com.javaee6.webmvc.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaee6.webmvc.demo.model.dto.BookDto;
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
	@Override
	public void addBook(BookDto book) {
		this.books.add(book);

	}
	@Override
	public Optional<BookDto> getBookById(Long bookId) {

		BookDto result = null;
		for (BookDto book : this.books) {
			if(book.getId().equals(bookId))
			{
				result = book;
				break;
			}
		}
		return result==null? Optional.empty() : Optional.of(result);
	}
	@Override
	public void updateBook(BookDto book) {
		BookDto bookToUpdate = this.getBookById(book.getId()).get();
		bookToUpdate.setAuthor(book.getAuthor());
		bookToUpdate.setTitle(book.getTitle());
		bookToUpdate.setDescription(book.getDescription());
	}
	@Override
	public void deleteBook(BookDto book) {
		this.books.remove(book);

	}


}
