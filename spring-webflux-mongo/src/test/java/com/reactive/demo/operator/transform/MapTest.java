package com.reactive.demo.operator.transform;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@Slf4j
public class MapTest {
	
	@Test
	public void testMap()
	{
		Flux<Integer> flux = Flux.just(2,4,6,8,10);
		
		flux.subscribe(data->log.info("Normal "+data));
		flux.map(item->item*2)
			.subscribe(data->log.info("data "+data));
		
		Flux<String> items = Flux.just("Apple","Orange","Banana");
		Flux<Integer> lengths = items.map(item->item.length());//Flux<Integer>
			//.subscribe(len->log.info("length "+len));
		
		StepVerifier.create(lengths)
					.expectNext(5)
					.expectNext(6)
					.expectNext(6)
					.verifyComplete();
	}
}
