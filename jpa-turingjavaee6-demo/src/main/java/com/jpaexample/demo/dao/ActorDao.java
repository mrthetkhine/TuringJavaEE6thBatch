package com.jpaexample.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpaexample.demo.model.entity.Actor;
import com.jpaexample.demo.model.entity.Book;

@Repository
public interface ActorDao extends JpaRepository<Actor, Long> {

}
