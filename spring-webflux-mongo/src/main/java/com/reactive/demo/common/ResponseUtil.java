package com.reactive.demo.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.reactive.demo.dto.RestResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ResponseUtil {
	
	public Mono<ResponseEntity<RestResponse>> succesResponse(HttpStatus statusCode, String message, Object data)
	{
		RestResponse response =new RestResponse();
		response.setMessage(message);
		response.setData(data);
		ResponseEntity re = ResponseEntity.status(statusCode)
								.body(response);
		return Mono.just(re);
		
	}
	public Mono<ResponseEntity<RestResponse>> errorResponse(HttpStatus statusCode, String message, Object error)
	{
		RestResponse response =new RestResponse();
		response.setMessage(message);
		response.setError(error);
		ResponseEntity re = ResponseEntity.status(statusCode)
								.body(response);
		return Mono.just(re);
		
	}
}
