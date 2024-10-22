package com.reactive.demo.operator.creation;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class EmptyErrorTest {
	
	Mono<Integer> div(int a, int b)
	{
		if(b==0)
		{
			return Mono.error(new Exception("Invalid operand"));
		}
		else
		{
			return Mono.just(a/b);
		}
	}
	@Test
	public void testError()
	{
		div(10,2)
			.subscribe(data->log.info("Data "+data));
		div(10,0)
			.subscribe(data->log.info("Data subscribed2 "+data),
						(err)->log.error("Error "+err.getMessage()));
		
	}
	
	@Test
	public void testEmpty()
	{
		Mono.empty()
			.subscribe(data->log.info("Empty "),err->log.error("Error at empty"));
	}
}
