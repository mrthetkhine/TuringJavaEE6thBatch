package com.reactive.demo.operator.transform;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class FlatMapTest {
	Mono<Integer> toMono(Integer i)
	{
		return Mono.just(i);
	}
	@Test
	public void testFlatMap()
	{
		Flux<Integer> flux = Flux.range(0, 5);
		/*
		flux.map(item->toMono(item))
			.subscribe(data->{ //data-> Mono<Integer>
				data.subscribe(num->log.info("Real data "+num));
			});
		*/
		flux.flatMap(item->toMono(item))
			.subscribe(data->log.info("Data "+data));
		
	}
}
