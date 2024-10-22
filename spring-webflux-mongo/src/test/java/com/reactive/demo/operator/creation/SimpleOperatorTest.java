package com.reactive.demo.operator.creation;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@Slf4j
public class SimpleOperatorTest {
	
	@Test
	public void testSimple()
	{
		Flux<Integer> rangeOfIntegers = Flux.range(0, 10);
		rangeOfIntegers
			.subscribe(data->{
				log.info("Subscriber =>1 " +data);
			});
		rangeOfIntegers
		.subscribe(data->{
			log.info("Subscriber 2=> " +data);
		});
		log.info("Done");
	    StepVerifier.create(rangeOfIntegers).expectNextCount(10).verifyComplete();
	}
	
	@Test
	public void testJust()
	{
		Flux<String> flux = Flux.just("Hello","Hi");
		flux.subscribe(data->log.info("Just data "+data));
		
		StepVerifier.create(flux).expectNext("Hello")
					.expectNext("Hi")
					.verifyComplete();
				
	}
}
