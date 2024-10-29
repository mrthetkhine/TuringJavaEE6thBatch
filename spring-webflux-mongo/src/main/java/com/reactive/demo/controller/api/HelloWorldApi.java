package com.reactive.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.demo.controller.service.BlockingService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RestController
@RequestMapping(value="/api")
public class HelloWorldApi {
	
	@Autowired
	BlockingService blockingService;
	
	@GetMapping("/hello")
	Mono<String> hello()
	{
		log.info("Hello "+Thread.currentThread().getName());
		Mono<String> result = this.blockingService.getData();
									//.subscribeOn(Schedulers.boundedElastic());
		return result;
	}
}
