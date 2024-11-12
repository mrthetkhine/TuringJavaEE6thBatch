package com.reactive.demo.service;

import com.reactive.demo.security.*;
import com.reactive.demo.dto.TokenResponse;
import com.reactive.demo.model.User;

import reactor.core.publisher.Mono;

public interface AuthService {
	Mono<TokenResponse> register(User user);
	Mono<TokenResponse> login(User user);

}
