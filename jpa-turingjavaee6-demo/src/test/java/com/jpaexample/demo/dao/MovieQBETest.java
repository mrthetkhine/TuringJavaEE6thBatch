package com.jpaexample.demo.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.annotation.Rollback;

import com.jpaexample.demo.model.entity.Movie;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
@Rollback(false)
public class MovieQBETest {

	@Autowired 
	MovieDao movieDao;
	/*
	@Transactional
	@Test
	public void testMovieQBE()
	{
		log.info("Test case testMovieQBE");
		Movie movie = new Movie();
		movie.setYear(2010);
		movie.setGenre("Drama");
		
		ExampleMatcher matcher = ExampleMatcher.matching()
									.withIgnorePaths("genre");
		Example<Movie> example = Example.of(movie, matcher);
		
		List<Movie> movies = this.movieDao.findAll(example);
		
		movies.forEach(System.err::println);
	}*/
	@Transactional
	@Test
	public void testMovieQBEGetMovieWithTitle()
	{
		log.info("Test case testMovieQBE");
		Movie movie = new Movie();
		movie.setTitle("Movie");
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("title", match -> match.startsWith());
		Example<Movie> example = Example.of(movie, matcher);
		
		List<Movie> movies = this.movieDao.findAll(example);
		
		movies.forEach(System.err::println);
	}
}
