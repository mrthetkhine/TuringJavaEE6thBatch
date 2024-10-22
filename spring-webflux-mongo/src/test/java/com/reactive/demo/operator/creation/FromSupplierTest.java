package com.reactive.demo.operator.creation;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class FromSupplierTest {

	static String getData()
	{
		log.info("Get data called");
		return "Hello";
		
	}
	@Test
	public void testFromSupplier()
	{
		Mono<String> mono = Mono.fromSupplier(FromSupplierTest::getData);
		mono.subscribe(data->log.info("subscribed data"+data ));
		log.info("Before second subcribe");
		mono.subscribe(data->log.info("subscribed data2 "+data ));
	}
	
	Mono<String> getDeferedData(String data,long ms)
	{
		log.info("Defered getData executed "+data);
		try
		{
			Thread.sleep(ms);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Mono.just(data);
	}
	@Test
	public void testDefer()
	{
		Mono<String> first = Mono.defer(()->getDeferedData("Hello",2000));
		Mono<String> second = Mono.defer(()->getDeferedData("Hi",3000));
		log.info("Before subscribe");
		/*
		first.subscribe(data->{
			log.info("Subscried defer "+data);
			
		});*/
		Mono.zip(first, second)
			.subscribe(tuple->{
				log.info("Subscried defer=> "+tuple.getT1()+ " "+tuple.getT2());
			});
		log.info("End of line");
	}
}
