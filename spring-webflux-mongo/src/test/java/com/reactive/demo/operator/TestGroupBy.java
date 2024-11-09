package com.reactive.demo.operator;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.reactive.demo.WaitUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class TestGroupBy {
	
	
	//@Test
	public void testGroupBy()
	{
		Flux<String> items = Flux.just("Apple","Orange","Banana","Mango",
										"BlueBerry","Airplane","BlueSky",
										"Ordinary");
		
		items.groupBy((item)->{
			return item.charAt(0);
		})
		.flatMap(group->group.collectList())
		.subscribe(collections->{
			log.info("Group "+collections);
			
		});
		WaitUtil.delay(1000);
	}
}
