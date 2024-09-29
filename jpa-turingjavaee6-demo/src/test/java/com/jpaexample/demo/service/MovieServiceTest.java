package com.jpaexample.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
//@Rollback(false)
public class MovieServiceTest {
	@Autowired
	MovieService movieService;
	
	@Test
	public void testLazyLoading()
	{
		this.movieService.getMovieById(1L);
	}
}
