package com.reactive.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.reactive.demo.dto.TokenResponse;
import com.reactive.demo.model.User;
import com.reactive.demo.repository.UserRepository;
import com.reactive.demo.security.JwtAuthenticationManager;
import com.reactive.demo.security.JwtToken;
import com.reactive.demo.security.TokenProvider;
import com.reactive.demo.service.AuthService;

import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService{

	private final TokenProvider tokenProvider;
    private final JwtAuthenticationManager authenticationManager;
    
    @Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	ReactiveUserDetailsService userDetailsService;

    public AuthServiceImpl(TokenProvider tokenProvider,
    		JwtAuthenticationManager authenticationManager,
            Validator validation) {
		this.tokenProvider = tokenProvider;
		this.authenticationManager = authenticationManager;
	}
    
    @Override
	public Mono<TokenResponse> register(User user) {
		return this.userRepository.findByUsername(user.getUsername())
			    .map(userEntity->{
					throw new RuntimeException("User already exist");
				})
			    .switchIfEmpty(Mono.defer(()->this.registerUser(user)))
			    .cast(User.class)
			    .flatMap(saveUser->{
			    	log.info("New user have been saved "+saveUser);
			    	return this.login(user);
			    });
	}
	 Mono<User> registerUser(User user)
	    {
	    	User saveUser = new User();
	    	saveUser.setUsername(user.getUsername());
	    	saveUser.setPassword(this.passwordEncoder.encode(user.getPassword()));
	    	saveUser.setEmail(user.getEmail());
	    	saveUser.setRoles(user.getRoles());
	    	return this.userRepository.save(saveUser);
	    }
	@Override
	public Mono<TokenResponse> login(User user) {
		 return userDetailsService.findByUsername(user.getUsername())
	                .filter(u -> this.passwordEncoder.matches(user.getPassword() , u.getPassword()))
	                .map(tokenProvider::generateToken)
	                .map(token->new TokenResponse(token))
	                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.UNAUTHORIZED)));
	}

}
