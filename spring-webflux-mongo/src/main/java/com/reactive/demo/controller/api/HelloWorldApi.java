package com.reactive.demo.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value="/api")
public class HelloWorldApi {
	
	@GetMapping("/hello")
	Mono<String> hello()
	{
		try
		{
			Thread.sleep(6000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		log.info("Hello "+Thread.currentThread().getName());
		return Mono.just("Hello");
	}
}
