package com.reactive.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.demo.common.Mapper;
import com.reactive.demo.dto.ActorDto;
import com.reactive.demo.model.Actor;
import com.reactive.demo.repository.ActorRepository;
import com.reactive.demo.service.ActorService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	ActorRepository actorRepository;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public Flux<ActorDto> getAllActor() {
		
		return this.actorRepository.findAll()
					.map(actor->mapper.map(actor, ActorDto.class));
	}

	@Override
	public Mono<ActorDto> getActorById(String id) {
		return this.actorRepository.findById(id)
					.switchIfEmpty(Mono.error(new Exception("Actor with id "+id+" Not found")))
					.map(actor->mapper.map(actor,ActorDto.class));
	}

	@Override
	public Mono<ActorDto> saveActor(ActorDto dto) {
		Actor actor = this.mapper.map(dto, Actor.class);
		return this.actorRepository
					.save(actor)
					.map(act->this.mapper.map(actor, ActorDto.class));
	}

	@Override
	public Mono<ActorDto> updateActorById(String id, ActorDto dto) {
		
		
		return this.actorRepository
					.findById(id)
					.switchIfEmpty(Mono.error(new Exception("Actor with id "+id+" Not found")))
					.flatMap(actor->{
						actor.setFirstName(dto.getFirstName());
						actor.setLastName(dto.getLastName());
						return this.actorRepository.save(actor);
					})
					.map(actor->this.mapper.map(actor,ActorDto.class));
	}

	@Override
	public Mono<ActorDto> deleteActorById(String id) {
		
		return this.actorRepository
					.findById(id)
					.switchIfEmpty(Mono.error(new Exception("Actor with id "+id+" Not found")))
					.flatMap(actor->{
						return this.actorRepository
								    .deleteById(id)
								    .thenReturn(this.mapper.map(actor, ActorDto.class));
									
					});
					
	}

	
}
