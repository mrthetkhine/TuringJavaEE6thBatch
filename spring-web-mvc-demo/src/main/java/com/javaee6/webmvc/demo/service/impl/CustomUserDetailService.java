package com.javaee6.webmvc.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaee6.webmvc.demo.config.Config;
import com.javaee6.webmvc.demo.dao.UserRepository;
import com.javaee6.webmvc.demo.model.Role;
import com.javaee6.webmvc.demo.model.User;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailService  implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		log.info("loadByUserName " +user);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return createSpringSecurityUser(user);
	}
	@Transactional
	private org.springframework.security.core.userdetails.User createSpringSecurityUser(User user) {
		for(Role role : user.getRoles())
		{
			log.info("Role for "+ user.getUsername()+" Role "+role.getRole());
		}
        List<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                grantedAuthorities);
    }

}
