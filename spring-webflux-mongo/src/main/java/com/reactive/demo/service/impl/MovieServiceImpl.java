package com.reactive.demo.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.reactive.demo.dto.ActorDto;
import com.reactive.demo.dto.MovieDetailsDto;
import com.reactive.demo.dto.MovieDto;
import com.reactive.demo.model.Movie;
import com.reactive.demo.model.Actor;
import com.reactive.demo.model.MovieDetails;
import com.reactive.demo.model.Review;
import com.reactive.demo.repository.ActorRepository;
import com.reactive.demo.repository.MovieRepository;
import com.reactive.demo.repository.ReviewRepository;
import com.reactive.demo.service.MovieService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieServiceImpl implements MovieService{

	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ActorRepository actorRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	public Flux<MovieDto> getAllMovie() {
		return this.movieRepository
					.findAll()
					//.map(m->entityToDto(m));
					.map(this::entityToDto);
	}
	@Override
	public Flux<MovieDto> getAllMovieWithYearGt(Long year) {
		
		return this.movieRepository
				.findByYear(year)
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
	@Override
	public Mono<MovieDto> deleteMovieById(String movieId) {
		return this.movieRepository.findById(movieId)
				.switchIfEmpty(Mono.error(new Exception("Movie with id "+movieId+" Not found")))
				.flatMap(movie->{
					return this.movieRepository.deleteById(movieId)
							   .thenReturn(this.entityToDto(movie));
					
				});
	}
	@Override
	public Mono<MovieDto> assignActorToMovie(String movieId, String actorId) {
		
		return this.movieRepository.findById(movieId)
					.switchIfEmpty(Mono.error(new Exception("Movie with id "+movieId+" Not found")))
					.flatMap(movie->{
						return this.actorRepository.findById(actorId)
									.switchIfEmpty(Mono.error(new Exception("Actor with id "+actorId+" Not found")))
									.flatMap(actor->{
										movie.getActors().add(actor);
										return this.movieRepository.save(movie);
									});
					})
					.map(this::entityToDto);
	}
	@Override
	public Flux<MovieDto> getllMovieByDirector(String director) {
		return this.movieRepository
				.getMovieByDirector(director)
				//.map(m->entityToDto(m));
				.map(this::entityToDto);
	}
	@Override
	public Flux<MovieDto> getMovieWithAverageRatingGTE(int averageRating) {
		return this.reviewRepository
		.findAll()
		.groupBy(review->review.getMovie().getId())
		.flatMap(group->group.collectList())
		.map(reviews->getAverageRating(reviews))
		.filter(pair->pair.getSecond()>=averageRating)
		.map(pair->pair.getFirst())
		.map(this::entityToDto);
	}
	private Pair<Movie, Double> getAverageRating(List<Review> reviews) {
		double sum = 0;
		for(Review r: reviews)
		{
			sum += r.getRating();
		}
		Double average= new Double(sum/ reviews.size());
		
		return Pair.of(reviews.get(0).getMovie(),average);
	}
	
	

}
