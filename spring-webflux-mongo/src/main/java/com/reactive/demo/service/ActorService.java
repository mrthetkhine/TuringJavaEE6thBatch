package com.reactive.demo.service;

import com.reactive.demo.dto.ActorDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ActorService {
	Flux<ActorDto> getAllActor();
	Mono<ActorDto> getActorById(String id);
	Mono<ActorDto> saveActor(ActorDto dto);
	Mono<ActorDto> updateActorById(String id,ActorDto dto);
	Mono<ActorDto> deleteActorById(String id);
	
}
