package com.jpaexample.demo.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jpaexample.demo.model.entity.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
public class BookDaoQueryMethodTest {
	@Autowired 
	private BookDao bookDao;
	
	/*
	@Test
	void findAllBook()
	{
		log.info("Test case executed");
		List<Book> books = this.bookDao.findAll();
		assertTrue( books.size()>0);
	}
	*/
	/*
	@Test
	void testFindByYear()
	{
		List<Book> allBook = this.bookDao.findByYear(2010L);
		for(Book book : allBook)
		{
			assertEquals(2010L, book.getYear());
			log.info("Book "+book);
		}
	}
	@Test
	void testFindByYearAndTitle()
	{
		List<Book> allBook = this.bookDao.findByYearOrTitle(2015L,"Title 1");
		for(Book book : allBook)
		{
			//assertEquals(2010L, book.getYear());
			log.info("Book "+book);
		}
	}
	@Test
	void testFindByYearGreaterThanOrEqual()
	{
		List<Book> allBook = this.bookDao.findByYearGreaterThanEqual(2010L);
		for(Book book : allBook)
		{
			//assertEquals(2010L, book.getYear());
			log.info("Book "+book);
		}
	}
	
	
	@Test
	void testFindByTitleStartingWith()
	{
		List<Book> allBook = this.bookDao.findByTitleStartingWith("Title");
		for(Book book : allBook)
		{
			assertTrue(book.getTitle().startsWith("Title"));
			log.info("Book "+book);
		}
	}
	
	@Test
	void testFindByAuthorOrderByYearDesc()
	{
		List<Book> allBook = this.bookDao.findByAuthorOrderByYearDesc("Author 1");
		for(Book book : allBook)
		{
			//assertTrue(book.getTitle().startsWith("Title"));
			log.info("Book "+book);
		}
	}
	
	@Test
	void testFindYearIn()
	{
		List<Long> years = new ArrayList<>();
		years.add(2010L);
		years.add(2015L);
		List<Book> allBook = this.bookDao.findByYearIn(years);
		for(Book book : allBook)
		{
			//assertTrue(book.getTitle().startsWith("Title"));
			log.info("Book "+book);
		}
	}
	*/
	@Test
	
	void testFindByTitleQuery()
	{
		
		//Book book = this.bookDao.findByBookTitle("Title 1");
		Book book = this.bookDao.findByBookTitleWithNative("Title 1");
		log.info("Book "+book);
	}
}
