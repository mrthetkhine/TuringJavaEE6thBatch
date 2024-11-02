package com.reactive.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.demo.model.Actor;



public interface ActorRepository extends ReactiveMongoRepository<Actor,String>{

}
