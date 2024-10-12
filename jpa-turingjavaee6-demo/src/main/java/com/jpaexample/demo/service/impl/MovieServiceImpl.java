package com.jpaexample.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpaexample.demo.common.Mapper;
import com.jpaexample.demo.dao.ActorDao;
import com.jpaexample.demo.dao.MovieDao;
import com.jpaexample.demo.model.dto.MovieDto;
import com.jpaexample.demo.model.entity.Actor;
import com.jpaexample.demo.model.entity.Comment;
import com.jpaexample.demo.model.entity.Movie;
import com.jpaexample.demo.model.entity.MovieDetails;
import com.jpaexample.demo.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieDao movieDao;
	
	@Autowired
	ActorDao actorDao;
	
	@Autowired
	Mapper mapper;
	
	@Transactional
	@Override
	public Optional<MovieDto> getMovieById(Long id) {
		Optional<Movie> result = this.movieDao.findById(id);
		if(result.isPresent())
		{
			System.err.println("Movie id "+id+" exist Actor size "+ result.get().getActors().size());
			MovieDto movieDto = this.mapper.map(result.get(), MovieDto.class);
			return Optional.of(movieDto);
		}
		else
		{
			return Optional.empty();
		}
		
	}

	@Transactional
	@Override
	public List<MovieDto> getAllMovie() {
		List<MovieDto> moviesDtoList = new ArrayList<MovieDto>();
		List<Movie> movies = this.movieDao.findAll();
		moviesDtoList = mapper.mapList(movies, MovieDto.class);
		return moviesDtoList;
	}
	
	@Transactional
	@Override
	public List<MovieDto> getAllMovieByTitle(String title) {
		List<MovieDto> moviesDtoList ;
		List<Movie> movies = this.movieDao.getAllMovieInTitleLike(title);
		moviesDtoList = mapper.mapList(movies, MovieDto.class);
		return moviesDtoList;
	}

	@Transactional
	@Override
	public MovieDto saveMovie(MovieDto movieDto) {
		Movie movie = this.mapper.map(movieDto, Movie.class);
		MovieDetails movieDetails = movie.getMovieDetails();
		movie.setMovieDetails(movieDetails);
		movieDetails.setMovie(movie);
		log.info("Movie details "+movie.getMovieDetails());
		
		this.movieDao.save(movie);
		MovieDto savedMovie = this.mapper.map(movie, MovieDto.class); 
		
		return savedMovie;
	}

	@Transactional
	@Override
	public MovieDto updateMovie(MovieDto movieDto) {
		
		Movie movieToBeUpdate = this.mapper.map(movieDto, Movie.class);
		Optional<Movie> movieEntityResult = this.movieDao.findById(movieToBeUpdate.getId());
		
		Movie movie = movieEntityResult.get();
		movie.setTitle(movieToBeUpdate.getTitle());
		movie.setGenre(movieToBeUpdate.getGenre());
		movie.setYear(movieToBeUpdate.getYear());
		movie.getMovieDetails().setDetails(movieToBeUpdate.getMovieDetails().getDetails());
		
		this.movieDao.save(movie);
		
		MovieDto updatedMovie = this.mapper.map(movie, MovieDto.class); 
		
		return updatedMovie;
	}

	@Transactional
	@Override
	public MovieDto deleteMovieById(Long movieId) {
		Optional<Movie> movieEntityResult = this.movieDao.findById(movieId);

		MovieDto dto = this.mapper.map(movieEntityResult.get(), MovieDto.class); 
		this.movieDao.deleteById(movieId);
		return dto;
	}

	@Transactional
	@Override
	public MovieDto assignActorToMovie(Long movieId, Long actorId) {
		Movie movie = this.movieDao.getById(movieId);
		Actor actor = this.actorDao.getById(actorId);
		movie.getActors().add(actor);
		
		this.movieDao.save(movie);
		
		MovieDto dto = this.mapper.map(movie, MovieDto.class); 
		return dto;
	}

	

}
