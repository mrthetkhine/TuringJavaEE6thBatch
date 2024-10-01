package com.jpaexample.demo.dao.specification;

import java.util.ArrayList;
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
	/*
	@Transactional
	@Test
	public void testMovieSpecGetByYearGte()
	{
		List<Movie> movies = this.movieDao.findAll(MovieSpecification.getMovieByYearGreaterThan(2010L));
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}*/
	/*
	@Transactional
	@Test
	public void testMovieSpecGetByYearBtween()
	{
		List<Movie> movies = this.movieDao.findAll(MovieSpecification.getMovieByYearBetween(2010L,2015L));
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}*/
	/*
	@Transactional
	@Test
	public void testMovieSpecGetTitleLike()
	{
		List<Movie> movies = this.movieDao.findAll(MovieSpecification.getMovieByTitleLike("Movie"));
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}*/
	/*
	@Transactional
	@Test
	public void testMovieSpecWithTitleOnly()
	{
		List<Movie> movies = this.movieDao.findAll(MovieSpecification.getMovieByTitleOrYear("Movie 1",2010L));
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}*/
	/*
	@Transactional
	@Test
	public void testMovieSpecMovieWithActor()
	{
		List<Movie> movies = this.movieDao.findAll(MovieSpecification.getMovieWhereActorIn("Actor One"));
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}*/
	/*
	@Transactional
	@Test
	public void testMovieSpecMovieGenere()
	{
		List<Movie> movies = this.movieDao.findAll(MovieSpecification.getMovieGroupByGenere("Drama"));
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}*/
	@Transactional
	@Test
	public void testMovieSpecMovieGenereIn()
	{
		List<String> genres = new ArrayList<>();
		genres.add("Drama");
		genres.add("Sci-Fi");
		List<Movie> movies = this.movieDao.findAll(MovieSpecification.getMovieInGenere(genres));
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}
}
