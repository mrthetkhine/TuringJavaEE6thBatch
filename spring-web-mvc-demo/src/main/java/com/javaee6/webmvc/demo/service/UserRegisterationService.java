package com.javaee6.webmvc.demo.service;

import com.javaee6.webmvc.demo.model.dto.UserDto;

public interface UserRegisterationService {
	UserDto registerUser(UserDto userDto)throws Exception ;
}
