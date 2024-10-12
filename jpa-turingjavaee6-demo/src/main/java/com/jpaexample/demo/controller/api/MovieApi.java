package com.jpaexample.demo.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.jpaexample.demo.controller.api.exception.BeanValidationException;
import com.jpaexample.demo.controller.api.exception.DataNotFoundException;
import com.jpaexample.demo.dao.MovieDao;
import com.jpaexample.demo.model.dto.ActorDto;
import com.jpaexample.demo.model.dto.MovieDto;
import com.jpaexample.demo.model.entity.Book;
import com.jpaexample.demo.model.entity.Movie;
import com.jpaexample.demo.service.ActorService;
import com.jpaexample.demo.service.MovieService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//@Controller
@RequestMapping("/api/movies")
public class MovieApi {
	

	@Autowired
	MovieService movieService;

	@Autowired
	ActorService actorService;
	
	@GetMapping
	List<MovieDto> getAllMovie()
	{
		log.info("getAll Movie rest API ");
		return this.movieService.getAllMovie();
	}
	
	
	@GetMapping("/{movieId}")
	ResponseEntity<MovieDto> getMovieById(@PathVariable Long movieId) throws DataNotFoundException
	{
		log.info("getMovieById "+movieId);
		Optional<MovieDto> movieDto = this.movieService.getMovieById(movieId);
		if(movieDto.isPresent())
		{
			return ResponseEntity.ok(movieDto.get());
		}
		else
		{
			throw new DataNotFoundException("Movie id "+movieId+ " not found");
		}
	}
	@GetMapping("/title")
	ResponseEntity<List<MovieDto>> findMovieByTitle(@RequestParam String title) throws DataNotFoundException
	{
		log.info("find movie by title "+title);
		List<MovieDto> movies = this.movieService.getAllMovieByTitle(title);
		return ResponseEntity.ok(movies);
	}
	@PostMapping
	public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto,
												BindingResult bindingResult)throws BeanValidationException {
		log.info("binding result "+bindingResult.hasErrors() );
		if(!bindingResult.hasErrors())
		{
			MovieDto savedMovie = this.movieService.saveMovie(movieDto);
			return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(savedMovie);
		}
		else
		{
			//custom error
			throw new BeanValidationException(bindingResult.getAllErrors());
		}
	}
	@PutMapping(value="/{movieId}")
	public ResponseEntity<MovieDto> updateMovieById(@PathVariable Long movieId,
													@Valid @RequestBody MovieDto movieDto,
													BindingResult bindingResult) 
															throws DataNotFoundException, BeanValidationException {
		if(!bindingResult.hasErrors())
		{
			Optional<MovieDto> movie = this.movieService.getMovieById(movieId);
			
			if(movie.isPresent())
			{
				movieDto.setId(movieId);
				MovieDto dto = this.movieService.updateMovie(movieDto);
				return ResponseEntity.of(Optional.of(dto));
			}
			else
			{
				throw new DataNotFoundException("Movie with id " + movieId + " not found");
			}
		}
		else
		{
			//custom error
			throw new BeanValidationException(bindingResult.getAllErrors());
		}
	}
	@DeleteMapping(value="/{movieId}")
	public ResponseEntity<MovieDto> deleteMovieById(@PathVariable Long movieId) 
															throws DataNotFoundException{
		Optional<MovieDto> movie = this.movieService.getMovieById(movieId);
		
		if(movie.isPresent())
		{
			
			MovieDto dto = this.movieService.deleteMovieById(movieId);
			return ResponseEntity.of(Optional.of(dto));
		}
		else
		{
			throw new DataNotFoundException("Movie with id " + movieId + " not found");
		}
	}
	@PostMapping("/{movieId}/assignment/actors/{actorId}")
	ResponseEntity<MovieDto> assignActorToMovie(@PathVariable Long movieId,
			@PathVariable Long actorId) throws DataNotFoundException
	{
		log.info("getMovieById "+movieId);
		Optional<MovieDto> movieDto = this.movieService.getMovieById(movieId);
		Optional<ActorDto> actorDto = this.actorService.getActorById(actorId);
		if(movieDto.isPresent() && actorDto.isPresent())
		{
			MovieDto result = this.movieService.assignActorToMovie(movieId, actorId);
			return ResponseEntity.ok(result);
		}
		else
		{
			throw new DataNotFoundException("Movie id "+movieId+ " or actor "+actorId+" not found");
		}
	}
}
