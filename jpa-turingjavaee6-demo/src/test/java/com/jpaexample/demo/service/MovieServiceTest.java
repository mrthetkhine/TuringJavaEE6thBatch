package com.jpaexample.demo.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.jpaexample.demo.model.dto.MovieDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
@Rollback(false)
public class MovieServiceTest {
	@Autowired
	MovieService movieService;
	
	/*
	@Test
	public void testLazyLoading()
	{
		Optional<MovieDto> movie = this.movieService.getMovieById(2L);
		log.info("Actor "+movie.get().getActors().size());
		
	}
	*/
	
	@Test
	public void testAddActor()
	{
		this.movieService.assignActorToMovie(2L, 11L);
		this.movieService.assignActorToMovie(2L, 10L);
	}
}
