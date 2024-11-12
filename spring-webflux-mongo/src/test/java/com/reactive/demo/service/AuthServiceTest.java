package com.reactive.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.demo.WaitUtil;
import com.reactive.demo.model.Role;
import com.reactive.demo.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class AuthServiceTest {
	
	@Autowired
	AuthService authService;
	
	
	//@Test
	public void testRegsiterUser()
	{
		User user = new User();
		user.setUsername("admin");
		user.setEmail("admin@gmail.com");
		user.setPassword("admin");
		List<Role> roles= new ArrayList<Role>();
		
		Role role = new Role();
		role.setRole("ROLE_ADMIN");
		roles.add(role);
		user.setRoles(roles);
		
		this.authService.register(user)
						.subscribe(token->{
							log.info("Token "+token.getToken());
						});
		WaitUtil.delay(1000);
	}
	@Test 
	public void testLogin()
	{
		User user = new User();
		user.setUsername("admin");
		user.setEmail("admin@gmail.com");
		user.setPassword("admin");
		user.setPassword("admin");
		List<Role> roles= new ArrayList<Role>();
		
		Role role = new Role();
		role.setRole("ROLE_ADMIN");
		roles.add(role);
		user.setRoles(roles);
		
		this.authService
			.login(user)
			.subscribe(resp->{
				log.info("Token "+ resp.getToken());
			});
						
	}
}
