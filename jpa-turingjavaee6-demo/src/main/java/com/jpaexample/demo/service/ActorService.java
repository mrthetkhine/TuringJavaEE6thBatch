package com.jpaexample.demo.service;

import java.util.Optional;

import com.jpaexample.demo.model.dto.ActorDto;

public interface ActorService {
	Optional<ActorDto> getActorById(Long id);
}
