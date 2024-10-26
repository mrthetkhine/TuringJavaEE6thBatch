package com.reactive.demo.operator.transform;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class CombineTestTwo {
	//@Test
	public void testZipWith()
	{
		Mono<String> str = Mono.just("Hello");
		Mono<Integer> intItem = Mono.just(100);
		
		Mono.zip(str, intItem)
			.subscribe(tuple->{
				log.info("Tuple "+tuple.getT1() + " Int "+tuple.getT2());
			});
	}
	
	@Test
	public void testCoordination()
	{
		log.info("Started");
		Mono<Void> first = Mono.fromRunnable(()->{
			log.info("First started");
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			log.info("First done");
		});
		Mono<Void> second = Mono.fromRunnable(()->{
			log.info("Second started");
			try
			{
				Thread.sleep(2000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			log.info("Second done");
		});
		
		Mono.when(first,second)
			.subscribe(item->{
				log.info("Item "+item);
			});
		try
		{
			Thread.sleep(5_000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
