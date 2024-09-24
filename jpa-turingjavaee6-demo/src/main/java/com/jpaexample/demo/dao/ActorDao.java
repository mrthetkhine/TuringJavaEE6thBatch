package com.jpaexample.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpaexample.demo.model.entity.Actor;
import com.jpaexample.demo.model.entity.Book;

@Repository
public interface ActorDao extends JpaRepository<Actor, Long> {

	@Query("SELECT actor from Actor actor WHERE (actor.name.firstName,actor.name.lastName)=(?1,?2)")
	List<Actor> getActorWithName(String firstName, String lastName);
	
	@Query("SELECT extract (year from birthday) FROM Actor ")
	List<Integer> getAllBirthYear();
	
	@Query("SELECT actor from Actor actor WHERE actor.gender IS NULL")
	List<Actor> getAllActorWithGenderIsNull();
	
	
}
