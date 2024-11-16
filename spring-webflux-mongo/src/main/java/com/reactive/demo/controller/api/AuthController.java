package com.reactive.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.demo.common.ResponseUtil;
import com.reactive.demo.dto.RestResponse;
import com.reactive.demo.dto.TokenResponse;
import com.reactive.demo.model.User;
import com.reactive.demo.service.AuthService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class AuthController {

	@Autowired
	AuthService authService;
	
	@Autowired
	ResponseUtil responseUtil;
	
	@PostMapping("/login")
	Mono<ResponseEntity<RestResponse>> login(@Valid @RequestBody User user)
	{
		return this.authService.login(user)
					.flatMap(response->responseUtil.succesResponse(HttpStatus.OK,"Success",response))
					.onErrorResume(err->responseUtil.errorResponse(HttpStatus.UNAUTHORIZED,"Invalid credential ",err.getMessage()));
	}
	
	@PostMapping("/register")
	Mono<ResponseEntity<RestResponse>> register(@Valid @RequestBody User user)
	{
		log.info("Register "+user.getUsername());
		return this.authService.register(user)
					.flatMap(response->responseUtil.succesResponse(HttpStatus.CREATED,"Success",response))
					.onErrorResume(err->responseUtil.errorResponse(HttpStatus.UNAUTHORIZED,"Invalid credential ",err.getMessage()));
	}
	
}
