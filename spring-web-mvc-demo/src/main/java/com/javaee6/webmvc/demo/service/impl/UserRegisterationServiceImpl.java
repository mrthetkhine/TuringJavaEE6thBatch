package com.javaee6.webmvc.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaee6.webmvc.demo.dao.UserRepository;
import com.javaee6.webmvc.demo.model.Role;
import com.javaee6.webmvc.demo.model.User;
import com.javaee6.webmvc.demo.model.dto.UserDto;
import com.javaee6.webmvc.demo.service.UserRegisterationService;

import jakarta.transaction.Transactional;

@Service
public class UserRegisterationServiceImpl implements UserRegisterationService{

	@Autowired
	SecurityUtil securityUtil;
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	@Override
	public UserDto registerUser(UserDto userDto) throws Exception {
		User existingUser = this.userRepository.findByUsername(userDto.getUsername());
		if(existingUser!=null)
		{
			throw new Exception("user already existed");
		}
		else
		{
			User user = new User();
			user.setUsername(userDto.getUsername());
			user.setPassword(securityUtil.getHash(userDto.getPassword()));
			
			Role role1 = new Role();
			role1.setRole("ROLE_USER");
			user.getRoles().add(role1);
			
			this.userRepository.save(user);
			
			userDto.setPassword(user.getPassword());
			return userDto;
		}
		
	}

}
