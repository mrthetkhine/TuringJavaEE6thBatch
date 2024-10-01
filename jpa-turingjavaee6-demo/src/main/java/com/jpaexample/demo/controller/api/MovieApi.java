package com.jpaexample.demo.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaexample.demo.dao.MovieDao;
import com.jpaexample.demo.model.entity.Book;
import com.jpaexample.demo.model.entity.Movie;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/movies")
public class MovieApi {
	
	@Autowired
	MovieDao movieDao;

	//@Transactional
	@GetMapping
	List<Movie> getAllMovie()
	{
		try
		{
			Thread.sleep(60_000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.movieDao.findAll();
	}
	
	
	@GetMapping("/{movieId}")
	Optional<Movie> getMovieById(@PathVariable Long movieId)
	{
		return this.movieDao.findById(movieId);
	}
	
	
}
