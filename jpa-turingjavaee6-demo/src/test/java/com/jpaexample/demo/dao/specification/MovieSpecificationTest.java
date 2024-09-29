package com.jpaexample.demo.dao.specification;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.jpaexample.demo.dao.MovieDao;
import com.jpaexample.demo.dao.jpql.ActorJQLTest;
import com.jpaexample.demo.model.entity.Movie;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
@Rollback(false)
public class MovieSpecificationTest {
	
	@Autowired
	MovieDao movieDao;
	
	/*
	@Transactional
	@Test
	public void testMovieSpecGetByYear()
	{
		List<Movie> movies = this.movieDao.findAll(MovieSpecification.getMovieByYear(2010L));
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}*/
	@Transactional
	@Test
	public void testMovieSpecWithTitleOnly()
	{
		List<Movie> movies = this.movieDao.findAll(MovieSpecification.getMovieByTitleOrYear("Movie 1",2010L));
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}
}
