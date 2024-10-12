package com.jpaexample.demo.service;

import java.util.List;
import java.util.Optional;

import com.jpaexample.demo.model.entity.Movie;
import com.jpaexample.demo.model.dto.MovieDto;

public interface MovieService {
	List<MovieDto> getAllMovie();
	List<MovieDto> getAllMovieByTitle(String title);
	MovieDto saveMovie(MovieDto movieDto);
	Optional<MovieDto> getMovieById(Long id);
	MovieDto updateMovie(MovieDto movieDto);
	MovieDto deleteMovieById(Long movieId);
	MovieDto assignActorToMovie(Long movieId, Long actorId);
}
