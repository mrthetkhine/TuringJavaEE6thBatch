package com.reactive.demo.operator.repeat;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.reactive.demo.WaitUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class IterativeTest {
	//@Test
	public void testRepeat()
	{
		Mono.just("Hello")	
			.repeat(3)
			.subscribe(data->{
				log.info("Data "+data);
			});
	}
	@Test
	public void testInterval()
	{
		Flux.interval(Duration.ofMillis(500))
			.subscribe(item->{
				log.info("Tick "+item);
			});	
		WaitUtil.delay(10_000);
	}
}
