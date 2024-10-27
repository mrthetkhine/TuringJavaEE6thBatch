package com.reactive.demo.operator;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

import com.reactive.demo.WaitUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class ErrorHandlingTest {
	Mono<Integer> div(int a, int b)
	{
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
			log.info("Started");
			WaitUtil.delay(1000);
			log.info("Done");
			return a/b;
		});
		return Mono.fromFuture(future);
	}
	//@Test
	public void testErrorSubscribe()
	{
		div(10,0)
			.subscribe(data->{
				log.info("Suceess "+data);
			},err->{
				log.info("Exception "+err);
			});
		WaitUtil.delay(3000);
	}
	//@Test
	public void testThenErorr()
	{
		Mono.just(10)
			.then(Mono.error(new Exception("This is error")))
			.subscribe(data->{
				log.info("Suceess "+data);
			},err->{
				log.info("Exception "+err);
			});
		
	}
	//@Test
	public void testTimeout()
	{
		div(10, 2)
			.timeout(Duration.ofSeconds(1))
			.subscribe(data->{
				log.info("Suceess "+data);
			},err->{
				log.info("Exception "+err);
			});
		WaitUtil.delay(3000);
	}
	//@Test
	public void testOnErrorReturn()
	{
		div(10, 0)
			.onErrorReturn(100)
			.subscribe(data->{
				log.info("Suceess "+data);
			},err->{
				log.info("Exception "+err);
			});
		WaitUtil.delay(3000);
	}
	//@Test
	public void testOnErrorResume()
	{
		Flux.just(10,3,0,3,5)
			.map(item->10/item)
			/*
			.onErrorResume(err->{
				return Mono.just(-1);
			})*/
			.onErrorContinue( Exception.class,(ex,o)->{
				log.info("Exception " + ex + " O "+o);
				
			})
			.subscribe(data->{
				log.info("Suceess "+data);
			},err->{
				log.info("Exception "+err);
			});
		WaitUtil.delay(3000);
	}
	@Test
	public void testOnErrorMap()
	{
		div(10,2)
			.onErrorMap(e->{
				return new Exception("Mapped exception");
			})
			.doFinally(item->{
				log.info("Run finally");
			})
			.subscribe(data->{
				log.info("Suceess "+data);
			},err->{
				log.info("Exception "+err);
			});
		WaitUtil.delay(3000);
	}
}
