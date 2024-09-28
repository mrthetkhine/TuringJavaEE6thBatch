package com.jpaexample.demo.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jpaexample.demo.model.entity.Actor;
import com.jpaexample.demo.model.entity.Book;
import com.jpaexample.demo.model.entity.Gender;
import com.jpaexample.demo.model.entity.Movie;
import com.jpaexample.demo.model.entity.Name;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
public class ActorDaoTest {
	
	@Autowired 
	ActorDao actorDao;
	
	/*
	@Test
	void insertActor()
	{
		for(int i=0;i< 30;i++)
		{
			Actor actor = new Actor();
			
			Name name = new Name();
			name.setFirstName("Actor");
			name.setLastName(String.valueOf(i+5));
			
			actor.setName(name);
			actor.setGender(Gender.Male);
			
			Date birthDate = new GregorianCalendar(1974, 10, 11).getTime();
			actor.setBirthday(birthDate);
			
			this.actorDao.save(actor);
		}
		
	}
	*/
	/*
	@Test 
	void getActorById()
	{
		Optional<Actor> actor = this.actorDao.findById(1L);
		log.info("Actor "+actor.get());
	}*/
	
}
