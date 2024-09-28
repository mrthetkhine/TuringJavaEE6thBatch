package com.jpaexample.demo.dao.jpql;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.jpaexample.demo.model.entity.Movie;
import com.jpaexample.demo.dao.MovieDao;
import com.jpaexample.demo.model.dto.*;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
@Rollback(false)
public class MovieHQLTest {

	@Autowired
	MovieDao movieDao;
	/*
	@Transactional
	@Test
	public void testGetAllMovie()
	{
		List<Movie> movies = this.movieDao.getAllMovie();
		assertTrue(movies.size()>0);
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}*/
	/*
	@Transactional
	@Test
	public void testGetAllTitleAndGenereMovie()
	{
		List<TitleAndGenre> allTitleAndGenres = this.movieDao.getAllTitleAndGenre();
		assertTrue(allTitleAndGenres.size()>0);
		for(TitleAndGenre pair : allTitleAndGenres)
		{
			log.info("Title " + pair.getTitle()+" Genre "+pair.getGenre());
		}
		
	}*/
	/*
	@Transactional
	@Test
	public void testGetGenreAndCountOfMovie()
	{
		List<GenreCountDto> allGenereCount = this.movieDao.getAllGeneresCount();
		assertTrue(allGenereCount.size()>0);
		for(GenreCountDto pair : allGenereCount)
		{
			log.info("Genre " + pair.getGenre()+" Genre "+pair.getCount()+" "+pair.getGenreUpperCase());
		}
		
	}*/
	/*
	@Transactional
	@Test
	public void testClassBasedProjectionMovie()
	{
		List<GenreCountDtoTwo> allGenereCount = this.movieDao.getAllGeneresCountV2();
		assertTrue(allGenereCount.size()>0);
		for(GenreCountDtoTwo pair : allGenereCount)
		{
			log.info("Genre " + pair.getGenre()+" Genre "+pair.getCount());
		}
		
	}*/
	/*
	@Transactional
	@Test
	public void testGetAllGenere()
	{
		List<String> allGenre = this.movieDao.getAllGenere();
		assertTrue(allGenre.size()>0);
		for(String genre : allGenre)
		{
			log.info("Genre " + genre);
		}
		
	}*/
	/*
	@Transactional
	@Test
	public void tetGetAllMovieWithTitle()
	{
		List<Movie> movies = this.movieDao.getAllMovieLike("Movie");
		assertTrue(movies.size()>0);
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
		
	}*/
	/*
	@Transactional
	@Test
	public void testGenereCount()
	{
		int count = this.movieDao.findTotalMovieByGenres("Drama");
		log.info("Drama count "+count);
		
	}*/
	/*
	@Transactional
	@Test
	public void testMovieWithYear()
	{
		List<Movie> movies = this.movieDao.getAllMovieWithYearGTE(2015);
		assertTrue(movies.size()>0);
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
		
	}*/
	/*
	@Transactional
	@Test
	public void testMovieWithYearAndGenre()
	{
		List<Movie> movies = this.movieDao.getAllMovieWithYearAndGenere(2015,"Drama");
		assertTrue(movies.size()>0);
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
		
	}*/
	/*
	@Transactional
	@Test
	public void testMovieWithYearBetween()
	{
		List<Movie> movies = this.movieDao.getAllMovieWithYearBetweeen(2015, 2020);
		assertTrue(movies.size()>0);
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
		
	}*/
	/*
	@Transactional
	@Test
	public void testMovieWithActorIn()
	{
		List<Movie> movies = this.movieDao.getMovieWithActorIn("Actor", "One");
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}*/
	
	/*
	@Transactional
	@Test
	public void testMovieWithActorWithFirstNameIn()
	{
		List<Movie> movies = this.movieDao.getMovieWithActorWithFristNameIn("Actor");
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}*/
	/*
	@Transactional
	@Test
	public void testGetMovieWithComment()
	{
		List<Movie> movies = this.movieDao.getMovieWithComments();
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}
	*/
	/*
	@Transactional
	@Test
	public void testGetMovieWithComment()
	{
		List<Movie> movies = this.movieDao.getMovieWithCommentIn("Comment 1");
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}*/
	/*
	@Transactional
	@Test
	public void testGetMovieWithCommentWithPath()
	{
		List<Movie> movies = this.movieDao.getMovieWithDetailPath("Movie 1 Details");
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}*/
	/*
	@Transactional
	@Test
	public void testMovieWithOrderByTitle()
	{
		List<Movie> movies = this.movieDao.getMovieOrderByTitle();
		for(Movie movie : movies)
		{
			log.info("Movie "+movie);
		}
	}
	*/
	@Test
	@Transactional
	void testInsertTwoMovies()
	{
		int rowEffected = this.movieDao.insertTwoMovie( "MovieTitle1", "MovieTitle1");
		log.info("No of row updated "+rowEffected);
	}
}
