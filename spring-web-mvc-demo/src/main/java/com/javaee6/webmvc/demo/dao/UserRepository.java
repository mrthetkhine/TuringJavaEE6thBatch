package com.javaee6.webmvc.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaee6.webmvc.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	 User findByUsername(String username);
}
