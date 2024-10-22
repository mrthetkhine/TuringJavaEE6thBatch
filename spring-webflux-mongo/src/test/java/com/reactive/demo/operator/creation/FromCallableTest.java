package com.reactive.demo.operator.creation;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class FromCallableTest {

	@Test
	public void testFromCallable()
	{
		Mono<String> mono = Mono.fromCallable(()->{
			log.info("method in callable executed");
			return "Hello";
		});
		mono.subscribe(data->log.info("Subscribed data "+data));
		mono.subscribe(data->log.info("Subscribed2 data "+data));
	}
}
