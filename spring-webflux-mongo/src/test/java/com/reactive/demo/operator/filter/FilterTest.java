package com.reactive.demo.operator.filter;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.reactive.demo.WaitUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FilterTest {

	//@Test
	public void testFilter()
	{
		Flux<Integer> items = Flux.just(1,2,3,4,5);
		items.filter(item->item %2==0)
			  .subscribe(item->{
				 log.info("Even list "+item); 
			  });	
		Flux.just("Apple","Banana","Orange")
								.filter(fruit->fruit.length()>5)
								.subscribe(fruit->{
									log.info("Fruit " +fruit);
								});
	}
	//@Test
	public void testDistinct()
	{
		Flux<Integer> items = Flux.just(1,2,3,4,5,1,2,3,100);
		items.distinct()
			  .subscribe(item->{
				 log.info("Even list "+item); 
			  });	
	}
	//@Test
	public void testTake()
	{
		Flux<Integer> items = Flux.range(1, 100);
				
		items.take(5)
			  .subscribe(item->{
				 log.info("Top  "+item); 
			  });	
	}
	//@Test
	public void testTakeDuration()
	{
		Flux<Long> items = Flux.interval(Duration.ofMillis(100));
				
		items.take(Duration.ofSeconds(2))
			  .subscribe(item->{
				 log.info("Top  "+item); 
			  });	
		WaitUtil.delay(3000);
	}
	//@Test
	public void testElementAt()
	{
		Flux<Integer> items = Flux.range(1, 100);
				
		items.skip(3)
			.elementAt(4)
			  .subscribe(item->{
				 log.info("Top  "+item); 
			  });	
	}
	@Test
	public void testSingle()
	{
		Flux<Integer> items = Flux.range(1, 100);
		items = Flux.just(10);		
		items.single()
			  .subscribe(item->{
				 log.info("Top  "+item); 
			  });	
	}
}
