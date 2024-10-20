package com.reactive.demo.operator;
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
				System.out.println("Data " +data);
			});
		System.out.println("Done");
	    //StepVerifier.create(rangeOfIntegers).expectNextCount(10).verifyComplete();
	}
}
