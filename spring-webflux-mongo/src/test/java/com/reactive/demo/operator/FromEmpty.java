package com.reactive.demo.operator;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

import com.reactive.demo.WaitUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class FromEmpty {
	
	Mono<Integer> div(int a , int b)
	{
		if(b==0)
		{
			return Mono.empty();
		}
		else
		{
			return Mono.just(a/b);
		}
		
	}
	Mono<Integer> compute(int value)
	{
		log.info("Computed default "+value);
		return Mono.just(value);
	}
	//@Test
	public void testSwitchEmpty()
	{
		div(10,0)
			.defaultIfEmpty(20)
			//.switchIfEmpty(compute(10))
			.subscribe(result->{
				log.info("Result "+result);
			});
	}
	@Test
	public void testThen()
	{
		CompletableFuture<Integer> future= CompletableFuture.supplyAsync(() -> {
		    // Perform non-result producing task
		    log.info("Task executed asynchronously");
		    try
		    {
		    	Thread.sleep(2000);
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    log.info("Task Done");
		    return 100;
		});
		Mono<Integer> items =  Mono.fromFuture(future);
			items
			//.ignoreElements()
			//.then()
			//.thenReturn(500)
			.thenMany(Flux.just(10,20,30))
			.subscribe(item->{
				log.info("Done all "+item);
			});
		WaitUtil.delay(3000);
	}
	
}
