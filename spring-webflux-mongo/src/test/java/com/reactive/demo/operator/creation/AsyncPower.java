package com.reactive.demo.operator.creation;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class AsyncPower {
	
	
	@Test
	public void testAsyncCombine()
	{
		CompletableFuture<String> first = CompletableFuture.supplyAsync(() -> {
		    // Perform non-result producing task
		    log.info("Task executed asynchronously");
		    try
		    {
		    	Thread.sleep(3000);
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    return "Hello";
		});
		CompletableFuture<String> second = CompletableFuture.supplyAsync(() -> {
		    // Perform non-result producing task
		    log.info("Task2 executed asynchronously");
		    try
		    {
		    	Thread.sleep(5000);
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    return "Hi";
		});
		log.info("Done ");
		
		Mono<String> fristMono = Mono.fromFuture(first);
		Mono<String> secondMono = Mono.fromFuture(second);
		Mono.zip(fristMono, secondMono)
			.subscribe(tuple->log.info("T1 "+tuple.getT1()+ " T2 "+tuple.getT2()));
		log.info("Done fater subscribe");
		
		
		try
		{
			Thread.sleep(6000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		/*
		try
		{
			log.info("first "+first.get() + " second "+second.get());
			log.info("After get");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
	}
}
