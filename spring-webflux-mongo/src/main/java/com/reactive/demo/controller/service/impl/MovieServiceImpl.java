package com.reactive.demo.controller.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.demo.controller.service.MovieService;
import com.reactive.demo.dto.ActorDto;
import com.reactive.demo.dto.MovieDetailsDto;
import com.reactive.demo.dto.MovieDto;
import com.reactive.demo.model.Movie;
import com.reactive.demo.model.Actor;
import com.reactive.demo.model.MovieDetails;
import com.reactive.demo.repository.ActorRepository;
import com.reactive.demo.repository.MovieRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieServiceImpl implements MovieService{

	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ActorRepository actorRepository;
	@Override
	public Flux<MovieDto> getAllMovie() {
		return this.movieRepository
					.findAll()
					//.map(m->entityToDto(m));
					.map(this::entityToDto);
	}
	@Override
	public Mono<MovieDto> getMovieById(String movieId) {
		return this.movieRepository.findById(movieId)
							.switchIfEmpty(Mono.error(new Exception("Movie id "+movieId+" Not found")))
							.map(this::entityToDto);
	}
	MovieDto entityToDto(Movie movie)
	{
		MovieDto dto = modelMapper.map(movie, MovieDto.class);
		MovieDetailsDto movieDetailsDto = modelMapper.map(movie.getDetails(), MovieDetailsDto.class); 
		dto.setDetails(movieDetailsDto);
		
		List<ActorDto> actors = modelMapper.map(movie.getActors(), new TypeToken<List<ActorDto>>() {}.getType());
		dto.setActors(actors);
		
		return dto;
	}
	private Movie dtoToEntity(MovieDto movieDto) {
		Movie movie = modelMapper.map(movieDto, Movie.class);
		
		MovieDetails movieDetails =modelMapper.map(movieDto.getDetails(), MovieDetails.class); 
		movie.setDetails(movieDetails);
		
		if(movieDto.getActors()!=null)
		{
			List<Actor> actors = modelMapper.map(movieDto.getActors(), new TypeToken<List<Actor>>() {}.getType());
			movie.setActors(actors);
			
		}
		
		return movie;
	}
	@Override
	public Mono<MovieDto> saveMovie(MovieDto movieDto) {
		Movie movie = this.dtoToEntity(movieDto);
		return this.actorRepository.saveAll(movie.getActors())
							.collectList()//List<Actor>
							.flatMap(actors->{
								movie.setActors(actors);
								return this.movieRepository.save(movie);
							})
							.map(this::entityToDto);
		
	}
	@Override
	public Mono<MovieDto> updateMovieById(String movieId, MovieDto movieDto) {
		return this.movieRepository
					.findById(movieId)
					.switchIfEmpty(Mono.error(new Exception("Movie with id "+movieId+" Not found")))
					.flatMap(movie->{
						movieDto.setId(movieId);
						return this.saveMovie(movieDto);
					});
	}
	

}
