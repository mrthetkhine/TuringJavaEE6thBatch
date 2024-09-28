package com.jpaexample.demo.dao.jpql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	/*
	@Test
	@Transactional
	void testAllActorWithGenderIsNull()
	{
		List<Actor> actors = this.actorDao.getAllActorWithGenderIsNull();
		
		for(Actor actor:actors)
		{
			log.info("Actor " +actor);
		}
	}*/
	/*
	@Test
	@Transactional
	void testGetAllActorWithLimitOffset()
	{
		//10, 0->first page
		List<Actor> actors = this.actorDao.getActorWithLimitOffset(10,10);
		
		for(Actor actor:actors)
		{
			log.info("Actor " +actor);
		}
	}*/
	/*
	@Test
	@Transactional
	void testPaging()
	{
		Pageable firstPageWithTwoElements = PageRequest.of(1, 10);
		//10, 0->first page
		Page<Actor> actors = this.actorDao.findAll(firstPageWithTwoElements);
		
		for(Actor actor:actors)
		{
			log.info("Actor " +actor);
		}
	}*/
	/*
	@Test
	@Transactional
	void testUpdateQuery()
	{
		int rowEffected = this.actorDao.updateActorNameById(6L, "Actor", "Six");
		log.info("No of row updated "+rowEffected);
	}*/
	/*
	@Test
	@Transactional
	void testDeleteQuery()
	{
		int rowEffected = this.actorDao.deleteActorByName( "Actor", "34");
		log.info("No of row updated "+rowEffected);
	}*/
	
}
