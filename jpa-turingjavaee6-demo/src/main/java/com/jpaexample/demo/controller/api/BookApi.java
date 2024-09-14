package com.jpaexample.demo.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaexample.demo.dao.BookDao;
import com.jpaexample.demo.model.entity.Book;

@RestController
@RequestMapping("/api/books")
public class BookApi {

	@Autowired
	BookDao bookDao;
	
	@GetMapping
	List<Book> getAllBooks()
	{
		return this.bookDao.findAll();
	}
	
	@GetMapping("/{bookId}")
	Optional<Book> getBookById(@PathVariable Long bookId)
	{
		return this.bookDao.findById(bookId);
	}
	@PostMapping
	Book saveBook(@RequestBody Book book)
	{
		return this.bookDao.save(book);
	}
	
	@PutMapping("/{bookId}")
	Optional<Book> updateBook(@PathVariable Long bookId,@RequestBody Book book)
	{
		Optional<Book> existingBook = this.bookDao.findById(bookId);
		if(existingBook.isPresent())
		{
			book.setId(bookId);
			return Optional.of(this.bookDao.save(book));
		}
		else
		{
			return Optional.empty();
		}
	}
	@DeleteMapping("/{bookId}")
	Optional<Book> deleteBook(@PathVariable Long bookId)
	{
		Optional<Book> existingBook = this.bookDao.findById(bookId);
		if(existingBook.isPresent())
		{
			
			this.bookDao.deleteById(bookId);
			return existingBook;
		}
		else
		{
			return Optional.empty();
		}
	}
}
