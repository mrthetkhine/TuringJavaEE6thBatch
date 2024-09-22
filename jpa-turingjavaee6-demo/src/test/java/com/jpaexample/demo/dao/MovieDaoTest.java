package com.jpaexample.demo.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jpaexample.demo.model.entity.Actor;
import com.jpaexample.demo.model.entity.Book;
import com.jpaexample.demo.model.entity.Movie;
import com.jpaexample.demo.model.entity.MovieDetails;
import com.jpaexample.demo.model.entity.Name;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
@Rollback(false)
public class MovieDaoTest {
	
	@Autowired 
	MovieDao movieDao;
	
	@Autowired
	MovieDetailsDao movieDetailsDao;
	/*
	@Test
	void insertMovie()
	{
		Movie movie = new Movie();
		movie.setTitle("Movie 2");
		movie.setGenre("Drama");
		movie.setYear(2015);
		
		movie.setSomething("Nothing");
		
		MovieDetails movieDetails = new MovieDetails();
		movieDetails.setDetails("Movie 2 Details");
		movie.setMovieDetails(movieDetails);
		
		movieDetails.setMovie(movie);
		movieDao.save(movie);
		
		
	}*/
	/*
	@Test
	@Transactional
	void insertMovieWithActors()
	{
		Movie movie = this.movieDao.getById(2L);
		Actor actor1 = new Actor();
		
		Name actor1Name = new Name();
		actor1Name.setFirstName("Actor ");
		actor1Name.setLastName("Three ");
		actor1.setName(actor1Name);
		
		actor1.setBirthday(new Date());
	
		//List<Actor> actors = new ArrayList<>();
		//actors.add(actor1);
		
		Actor actor2 = new Actor();
		
		Name actor2Name = new Name();
		actor2Name.setFirstName("Actor ");
		actor2Name.setLastName("Four ");
		actor2.setName(actor2Name);
		actor2.setBirthday(new Date());
		
		
		//actors.add(actor2);
		
		movie.getActors().add(actor1);
		movie.getActors().add(actor2);
		
		actor1.getMovies().add(movie);
		actor2.getMovies().add(movie);
		
		movieDao.save(movie);
		
		
	}*/
	/*
	@Test 
	void getAllMovie()
	{
		List<Movie> movies = this.movieDao.findAll();
		for(Movie movie: movies)
		{
			log.info(movie.getTitle());
		}
	}*/
	/*
	@Test 
	@Transactional
	void testLazyLoading()
	{
		Optional<Movie> result = this.movieDao.findById(2L);
		Movie movie = result.get();
		log.info("Title "+movie.getTitle());
		
		List<Actor> actors = movie.getActors();
		for(Actor actor: actors)
		{
			log.info("Actor "+actor);
		}
	}*/
	@Test
	@Transactional 
	void testNativeQuery()
	{
		Movie movie = this.movieDao.findMovieWithTitleInNative("Movie 1");
		log.info("Title "+movie.getTitle());
		log.info("No of Actors "+movie.getActors().size());
	}
}
