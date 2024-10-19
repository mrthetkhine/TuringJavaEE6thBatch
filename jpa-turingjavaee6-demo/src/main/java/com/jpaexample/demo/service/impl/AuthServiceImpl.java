package com.jpaexample.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.jpaexample.demo.dao.UserRepository;
import com.jpaexample.demo.model.dto.UserDto;
import com.jpaexample.demo.model.entity.Role;
import com.jpaexample.demo.model.entity.User;
import com.jpaexample.demo.security.JwtService;
import com.jpaexample.demo.service.*;

import jakarta.transaction.Transactional;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	SecurityUtil securityUtil;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
    JwtService jwtService;
  

	    
	@Transactional
	@Override
	public void register(UserDto userDto) throws Exception {
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
			//return userDto;
		}
	}

	@Override
	public String login(UserDto userDto) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
        User u = userRepository.findByUsername(userDto.getUsername());
        return jwtService.generateToken(u);

	}
	
}
