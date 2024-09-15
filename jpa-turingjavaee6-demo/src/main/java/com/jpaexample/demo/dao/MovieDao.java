package com.jpaexample.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpaexample.demo.model.entity.Book;
import com.jpaexample.demo.model.entity.Movie;

@Repository
public interface MovieDao  extends JpaRepository<Movie, Long>{

}
