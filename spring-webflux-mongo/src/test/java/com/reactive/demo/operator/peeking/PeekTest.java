package com.reactive.demo.operator.peeking;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.reactive.demo.WaitUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class PeekTest {
	
	@Test
	public void testPeek()
	{
		Flux<Integer> items = Flux.just(1,2,3,4)
									.delayElements(Duration.ofMillis(100));
		items.doOnNext(item->{
			log.info("Do side effect "+item);
		})
		.doOnComplete(()->{
			log.info("Compelted");
		})
		.subscribe();
		
		WaitUtil.delay(1000);
	}
}
