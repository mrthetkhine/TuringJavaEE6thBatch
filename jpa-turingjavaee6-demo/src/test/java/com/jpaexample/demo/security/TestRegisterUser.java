package com.jpaexample.demo.security;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;

import com.jpaexample.demo.dao.UserRepository;
import com.jpaexample.demo.model.entity.Role;
import com.jpaexample.demo.model.entity.User;
import com.jpaexample.demo.service.impl.SecurityUtil;

import jakarta.transaction.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Rollback(false)
public class TestRegisterUser {
	@Autowired
	SecurityUtil securityUtil;
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	@Test
	public void addUser()
	{
		User user = new User();
		user.setUsername("user");
		user.setPassword(securityUtil.getHash("user"));
		
		Role role1 = new Role();
		//role1.setRole("ROLE_ADMIN");
		role1.setRole("ROLE_USER");
		
		user.getRoles().add(role1);
		
		this.userRepository.save(user);
	}
}
