package com.jpaexample.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexample.demo.common.Mapper;
import com.jpaexample.demo.dao.ActorDao;
import com.jpaexample.demo.model.dto.ActorDto;
import com.jpaexample.demo.model.dto.MovieDto;
import com.jpaexample.demo.model.entity.Actor;
import com.jpaexample.demo.service.ActorService;

import jakarta.transaction.Transactional;

@Service
public class ActorServiceImpl implements ActorService{

	@Autowired
	ActorDao actorDao;
	
	@Autowired
	Mapper mapper;
	
	@Transactional
	@Override
	public Optional<ActorDto> getActorById(Long id) {
		Optional<Actor> result = this.actorDao.findById(id);
		if(result.isPresent())
		{
			ActorDto actorDto = this.mapper.map(result.get(), ActorDto.class);
			return Optional.of(actorDto);
		}
		else
		{
			return Optional.empty();
		}
	}

}
