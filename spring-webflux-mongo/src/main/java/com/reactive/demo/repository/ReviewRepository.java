package com.reactive.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.demo.model.Movie;
import com.reactive.demo.model.Review;

public interface ReviewRepository extends ReactiveMongoRepository<Review,String>{

}
