package com.jpaexample.demo.dao.jpql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.jpaexample.demo.dao.ActorDao;
import com.jpaexample.demo.model.entity.Actor;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
@Rollback(false)
public class ActorJQLTest {
	
	@Autowired
	ActorDao actorDao;
	/*
	@Test
	@Transactional
	void testTupleComparison()
	{
		List<Actor> actors = this.actorDao.getActorWithName("Actor", "One");
		
		for(Actor actor:actors)
		{
			log.info("Actor " +actor);
		}
	}*/
	/*
	@Test
	@Transactional
	void testGetAllBirthYear()
	{
		List<Integer> years = this.actorDao.getAllBirthYear();
		
		for(Integer year:years)
		{
			log.info("BirthdayYear " +year);
		}
	}*/
	@Test
	@Transactional
	void testAllActorWithGenderIsNull()
	{
		List<Actor> actors = this.actorDao.getAllActorWithGenderIsNull();
		
		for(Actor actor:actors)
		{
			log.info("Actor " +actor);
		}
	}
}
