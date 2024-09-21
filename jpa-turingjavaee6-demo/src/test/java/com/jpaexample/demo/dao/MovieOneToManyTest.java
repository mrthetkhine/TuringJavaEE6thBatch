package com.jpaexample.demo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.jpaexample.demo.model.entity.Comment;
import com.jpaexample.demo.model.entity.Movie;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
@Rollback(false)
public class MovieOneToManyTest {
	@Autowired 
	MovieDao movieDao;
	
	/*
	@Test
	@Transactional
	public void testOneToMany()
	{
		Movie movie = new Movie();
		movie.setTitle("New Movie 4");
		
		Comment c1 = new Comment();
		c1.setComment("Comment 5");
		
		Comment c2 = new Comment();
		c2.setComment("Comment 6");
		
		movie.getComments().add(c1);
		movie.getComments().add(c2);
		
		this.movieDao.save(movie);
	}
	*/
	
	@Test
	@Transactional
	public void testOneToMany()
	{
		this.movieDao.deleteById(6L);
	}
	
}
