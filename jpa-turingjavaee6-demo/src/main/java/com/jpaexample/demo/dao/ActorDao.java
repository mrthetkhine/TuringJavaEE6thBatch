package com.jpaexample.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jpaexample.demo.model.entity.Actor;
import com.jpaexample.demo.model.entity.Book;

import jakarta.transaction.Transactional;

@Repository
public interface ActorDao extends PagingAndSortingRepository<Actor, Long> {

	@Query("SELECT actor from Actor actor WHERE (actor.name.firstName,actor.name.lastName)=(?1,?2)")
	List<Actor> getActorWithName(String firstName, String lastName);
	
	@Query("SELECT extract (year from birthday) FROM Actor ")
	List<Integer> getAllBirthYear();
	
	@Query("SELECT actor from Actor actor WHERE actor.gender IS NULL")
	List<Actor> getAllActorWithGenderIsNull();
	
	@Query("SELECT actor from Actor actor order by id LIMIT ?1 OFFSET ?2")
	List<Actor> getActorWithLimitOffset(Integer limit,Integer offset);
	
	@Modifying
	@Transactional
	@Query("UPDATE Actor actor SET actor.name.firstName = ?2, actor.name.lastName=?3 WHERE actor.id = ?1")
	int updateActorNameById(Long id, String firstName, String lastName);
	
	//Do not use delete with like in production
	@Modifying
	@Transactional
	@Query("DELETE Actor actor WHERE actor.name.firstName LIKE ?1 AND actor.name.lastName LIKE ?2")
	int deleteActorByName(String firstName, String lastName);
	
	
}
