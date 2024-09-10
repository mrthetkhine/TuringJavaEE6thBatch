package com.javaee6.webmvc.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.javaee6.webmvc.demo.common.Mapper;
import com.javaee6.webmvc.demo.dao.BookDao;
import com.javaee6.webmvc.demo.model.Book;
import com.javaee6.webmvc.demo.model.dto.BookDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public List<Book> getAllBook() {
	
		 return jdbcTemplate.query(
			      "SELECT id, title, author,description FROM Book;",
			      this::mapRowToBook);
	}
	private Book mapRowToBook(ResultSet row, int rowNum)throws SQLException
	{
		return new Book(row.getLong("ID"),
						row.getString("title"),
						row.getString("author") ,
						row.getString("author"));
	}
	@Override
	public Optional<Book> getBookById(Long id) {
		List<Book> books = jdbcTemplate.query(
			      "SELECT id, title, author FROM Book WHERE ID=?",
			      this::mapRowToBook,
			      id);
		if(books.size() ==1)
		{
			return Optional.of(books.get(0));
		}
		else
		{
			return Optional.empty();
		}
		
	}
	@Override
	public Book saveBook(BookDto bookDto) {
		Book book = this.mapper.getMapper().map(bookDto, Book.class);
		String INSERT_SQL =  "INSERT INTO Book ( author, title,description) values ( ?, ?,?)";
		/*
		jdbcTemplate.update(
			      "INSERT INTO Book ( author, title) values ( ?, ?)",
			      book.getAuthor(),
			      book.getTitle());
		*/
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
		    new PreparedStatementCreator() {
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		            PreparedStatement ps =
		                connection.prepareStatement(INSERT_SQL, new String[] {"id"});
		            ps.setString(1, book.getAuthor());
		            ps.setString(2, book.getTitle());
		            ps.setString(3, book.getDescription());
		            return ps;
		        }
		    },
		    keyHolder);
		book.setId(keyHolder.getKey().longValue());
		return book;
	}
	@Override
	public Book updateBook(BookDto bookDto) {
		String SQL = "UPDATE BOOK SET title=?, author=?, description=? WHERE id=?";
		this.jdbcTemplate.update(SQL, bookDto.getTitle(),bookDto.getAuthor(),bookDto.getDescription(),bookDto.getId());
		
		Book book = this.mapper.getMapper().map(bookDto, Book.class);
		log.info("updated Book "+book);
		return book;
	}
	@Override
	public Book deleteBookById(Long bookId) {
		Optional<Book> book = this.getBookById(bookId);
		
		String SQL ="DELETE FROM Book WHERE ID=?";
		this.jdbcTemplate.update(SQL,bookId);
		return book.get();
	}
	

}
