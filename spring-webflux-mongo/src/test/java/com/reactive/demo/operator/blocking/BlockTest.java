package com.reactive.demo.operator.blocking;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

import com.reactive.demo.WaitUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class BlockTest {
	
	@Test
	public void testBlock()
	{
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
			
			log.info("Started "+Thread.currentThread().getName());
			WaitUtil.delay(3000);
			log.info("Done");
			return 100/4;
		});
		Mono<Integer> mono = Mono.fromFuture(future);
		
		mono
			.publishOn(Schedulers.parallel())
			.subscribe(item->{
				
				log.info("Item "+item +" Thread name "+Thread.currentThread().getName());
			});
		
		log.info("Done all "+Thread.currentThread().getName());
		WaitUtil.delay(4000);
	}
}
