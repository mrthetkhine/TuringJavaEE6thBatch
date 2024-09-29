package com.jpaexample.demo.service;

import java.util.Optional;

import com.jpaexample.demo.model.entity.Movie;

public interface MovieService {
	Optional<Movie> getMovieById(Long id);
}
