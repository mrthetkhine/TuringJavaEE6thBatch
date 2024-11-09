package com.reactive.demo.service;

import com.reactive.demo.dto.*;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface MovieService {
	Flux<MovieDto> getAllMovie();
	Flux<MovieDto> getAllMovieWithYearGt(Long year);
	Mono<MovieDto> getMovieById(String movieId);
	
	Flux<MovieDto> getllMovieByDirector(String director);
	
	Mono<MovieDto> saveMovie(MovieDto movieDto);
	Mono<MovieDto> updateMovieById(String movieId,MovieDto movieDto);
	Mono<MovieDto> deleteMovieById(String movieId);
	Mono<MovieDto> assignActorToMovie(String movieId,String actorId);
	
	Flux<MovieDto> getMovieWithAverageRatingGTE(int averageRating);
}
