package com.jpaexample.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaexample.demo.model.entity.Movie;
import com.jpaexample.demo.model.entity.MovieDetails;

public interface MovieDetailsDao extends JpaRepository<MovieDetails, Long>{

}
