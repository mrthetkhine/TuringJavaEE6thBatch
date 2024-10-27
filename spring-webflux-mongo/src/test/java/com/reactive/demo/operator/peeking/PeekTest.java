package com.reactive.demo.operator.peeking;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import com.reactive.demo.WaitUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class PeekTest {
	
	//@Test
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
	
	//@Test
	public void testDoOnError()
	{
		Flux<Integer> items = Flux.just(1,2,0,4)
				.map(item-> 10/item)
				.delayElements(Duration.ofMillis(100));
		items.doOnNext(item->{
			log.info("On Next "+item);
		})
		.doOnError(err->{
			log.info("Eror "+err.getMessage());
		})
		.doOnComplete(()->{
			log.info("Compelted");
		}).subscribe();
		WaitUtil.delay(1000);
	}
	@Test
	public void testWebClientError()
	{
		WebClient client;
		client = WebClient.create("https://jsonplaceholder1.typicode.com");
		client.get()
				.uri("/todos/1")
				.retrieve()
				.bodyToMono(String.class)
				.doOnNext(item->{
					log.info("Response "+item);
				})
				.doOnError(err->{
					log.info("Erorr "+err);
				})
				.log()
				.subscribe();
		
		WaitUtil.delay(1000);
	}
}
