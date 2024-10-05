package com.jpaexample.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpaexample.demo.common.Mapper;
import com.jpaexample.demo.dao.MovieDao;
import com.jpaexample.demo.model.dto.MovieDto;
import com.jpaexample.demo.model.entity.Actor;
import com.jpaexample.demo.model.entity.Comment;
import com.jpaexample.demo.model.entity.Movie;

import com.jpaexample.demo.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieDao movieDao;
	
	@Autowired
	Mapper mapper;
	
	@Transactional
	@Override
	public Optional<MovieDto> getMovieById(Long id) {
		Optional<Movie> result = this.movieDao.findById(id);
		if(result.isPresent())
		{
			log.info("Movie id "+id+" exist ");
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
	public MovieDto saveMovie(MovieDto movieDto) {
		Movie movie = this.mapper.map(movieDto, Movie.class);
		log.info("Movie details "+movie.getMovieDetails());
		this.movieDao.save(movie);
		MovieDto savedMovie = this.mapper.map(movie, MovieDto.class); 
		return savedMovie;
	}

}
