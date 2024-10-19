package com.jpaexample.demo.service;

import com.jpaexample.demo.model.dto.UserDto;

public interface AuthService {
	public void register(UserDto userDto)throws Exception ;
	public String login(UserDto userDto); 
}
