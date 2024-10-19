package com.jpaexample.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaexample.demo.model.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	 User findByUsername(String username);
}
