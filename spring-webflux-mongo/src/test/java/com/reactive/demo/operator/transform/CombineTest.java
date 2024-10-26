package com.reactive.demo.operator.transform;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class CombineTest {
	
	static WebClient client;
	@BeforeAll
	public static void setup(){
		client = WebClient.create("https://jsonplaceholder.typicode.com");
	}
	
	Mono<String> getTodo(int i)
	{
		log.info("Fetch todo "+i);
		return client.get()
			.uri("/todos/"+i)
			.retrieve()
			.bodyToMono(String.class);
	}
	//Same as concat
	//@Test
	public void testBlockingFlow()
	{
		long start = System.currentTimeMillis();
		getTodo(1)
			.subscribe(todo1->{
				getTodo(2)
					.subscribe(todo2->{
						getTodo(3)
							.subscribe(todo3->{
								long end = System.currentTimeMillis();
								long time = end-start;
								log.info("Time " +time);
								log.info(todo1+" "+todo2+ " "+todo3);
							});
							
					});
			});
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testZip()
	{
		
		long start = System.currentTimeMillis();
		Mono<String> first = getTodo(1);
		Mono<String> second = getTodo(2);	
		Mono<String> third = getTodo(3);
		
		Mono.zip(first, second,third)
			.subscribe(tuple->{
				long end = System.currentTimeMillis();
				long time = end-start;
				log.info("Time " +time);
				log.info(tuple.getT1()+" "+ tuple.getT2()+" "+tuple.getT3());
			});
		log.info("Done ");
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void testConcat()
	{
		
		long start = System.currentTimeMillis();
		Mono<String> first = getTodo(1);
		Mono<String> second = getTodo(2);	
		Mono<String> third = getTodo(3);
		
		Flux.concat(first, second,third)
			.subscribe(tuple->{
				long end = System.currentTimeMillis();
				long time = end-start;
				log.info("Time " +time);
				log.info(tuple);
			});
		log.info("Done ");
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//@Test
	public void testMerge()
	{
		
		long start = System.currentTimeMillis();
		Mono<String> second = getTodo(2);	
		Mono<String> first = getTodo(1);
		Mono<String> third = getTodo(3);
		
		Flux.merge(first, second,third)
			.subscribe(tuple->{
				long end = System.currentTimeMillis();
				long time = end-start;
				log.info("Time " +time);
				log.info(tuple);
			});
		log.info("Done ");
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
