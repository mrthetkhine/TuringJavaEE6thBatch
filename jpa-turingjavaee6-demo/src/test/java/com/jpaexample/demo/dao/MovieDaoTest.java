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
import com.jpaexample.demo.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
public class MovieDaoTest {
	
	@Autowired 
	MovieDao movieDao;
	
	/*
	@Test
	void insertMovie()
	{
		Movie movie = new Movie();
		movie.setTitle("Movie 1");
		movie.setGenre("Drama");
		movie.setYear(2010);
		
		movie.setSomething("Nothing");
		movieDao.save(movie);
	}
	*/
	@Test 
	void getAllMovie()
	{
		List<Movie> movies = this.movieDao.findAll();
		for(Movie movie: movies)
		{
			log.info(movie+"");
		}
	}
}
