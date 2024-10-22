package com.reactive.demo.operator.creation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class FromArrayTest {

	@Test
	public void testFromArray()
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
		Mono<String> firstMono = Mono.fromFuture(first);
		firstMono.subscribe(data->log.info("From Future "+data));
		
		String[]items = {"Apple","Banana","Orange"};
		Flux<String> flux = Flux.fromArray(items);
		flux.subscribe(data->log.info("Item "+data));
		
		ArrayList<String> itemList = new ArrayList<>();
		itemList.add("one");
		itemList.add("two");
		itemList.add("three");
		
		Flux<String> second = Flux.fromIterable(itemList);
		second.subscribe(data->log.info("Item from iterable "+data));
		
	
		try
	    {
	    	Thread.sleep(4000);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
}
