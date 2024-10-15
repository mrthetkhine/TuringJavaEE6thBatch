package com.javaee6.webmvc.demo.security;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;

import com.javaee6.webmvc.demo.dao.UserRepository;
import com.javaee6.webmvc.demo.model.User;
import com.javaee6.webmvc.demo.model.Role;
import com.javaee6.webmvc.demo.service.impl.SecurityUtil;

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
		user.setUsername("admin");
		user.setPassword(securityUtil.getHash("admin"));
		
		Role role1 = new Role();
		//role1.setRole("ROLE_ADMIN");
		role1.setRole("ROLE_USER");
		
		user.getRoles().add(role1);
		
		this.userRepository.save(user);
	}
}
