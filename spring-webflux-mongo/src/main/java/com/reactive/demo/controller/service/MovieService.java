package com.reactive.demo.controller.service;

import com.reactive.demo.dto.*;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface MovieService {
	Flux<MovieDto> getAllMovie();
	Mono<MovieDto> getMovieById(String movieId);
	Mono<MovieDto> saveMovie(MovieDto movieDto);
	Mono<MovieDto> updateMovieById(String movieId,MovieDto movieDto);
}
