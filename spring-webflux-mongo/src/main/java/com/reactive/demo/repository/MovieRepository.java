package com.reactive.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.demo.model.Actor;
import com.reactive.demo.model.Movie;

public interface MovieRepository extends ReactiveMongoRepository<Movie,String>{

}
