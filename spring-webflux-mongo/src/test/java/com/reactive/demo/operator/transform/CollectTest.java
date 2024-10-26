package com.reactive.demo.operator.transform;

import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class CollectTest {
	@Test
	public void testCollect()
	{
		Flux<Integer> flux = Flux.range(1, 6);
		Mono<List<Integer>> list = flux.collectList();
		list.subscribe(items->{
			log.info(""+items);
		});
		Mono<Long> size = flux.count();
		size.subscribe(count->{
			log.info("Count "+count);
		});
		
		Mono<Boolean> allGtZero = flux.all(item->item>0);
		allGtZero.subscribe(result->{
			log.info("All greater than zero "+result);
		});
		Mono<Boolean> anyResult = flux.all(item->item==5);
		anyResult.subscribe(result->{
			log.info("anyResult "+result);
		});
	}
}
