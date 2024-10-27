package com.reactive.demo.operator;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

import com.reactive.demo.WaitUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class TryCatchProblem {
	
	@Test
	public void tryCatchProblem()
	{
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
			log.info("Started");
			WaitUtil.delay(3000);
			log.info("Done");
			return 100/0;
		});
		try
		{
			Mono.fromFuture(future)
				.subscribe(item->{
					log.info("Item "+item);
				});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		log.info("End");
		WaitUtil.delay(5000);
	}
}
