package com.reactive.demo.operator.creation;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class DeferTest {

	@Test
	public void testDefer()
	{
		Mono<String> mono = Mono.defer(()->{
			log.info("Defer code executed");
			return Mono.just("Hello");
		});
		log.info("Before subcribe");
		mono.subscribe(data->log.info("subscribed 1"+data));
		log.info("Before subcribe 2");
		mono.subscribe(data->log.info("subscribed 2"+data));
	}
}
