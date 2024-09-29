package com.jpaexample.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpaexample.demo.dao.MovieDao;
import com.jpaexample.demo.model.entity.Actor;
import com.jpaexample.demo.model.entity.Movie;

import com.jpaexample.demo.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieDao movieDao;
	
	@Transactional
	@Override
	public Optional<Movie> getMovieById(Long id) {
		Optional<Movie> result = this.movieDao.findById(id);
		List<Actor> actors = result.get().getActors();
		for(Actor actor : actors)
		{
			log.info("Actor "+actor);
		}
		
		return result;
	}

}
