package com.reactive.demo.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Service
public class BlockingService {

	Mono<String> blockingMethod()
	{
		try
		{
			Thread.sleep(10_000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Mono.just("Hello");
	}
	public Mono<String> getData()
	{
		Mono<String> data = this.blockingMethod()
								.subscribeOn(Schedulers.parallel())
								.publishOn(Schedulers.parallel());
		return data;
		
	}
}
