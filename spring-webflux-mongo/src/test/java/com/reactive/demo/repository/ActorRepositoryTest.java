package com.reactive.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.reactive.demo.model.Actor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@SpringBootTest
@Rollback(false)
public class ActorRepositoryTest {

	@Autowired
	ActorRepository actorRepository;

	@Test
	public void insertActorTest()
	{
		Actor actor = new Actor();
		actor.setFirstName("Kate");
		actor.setLastName("Winslect");
		
		this.actorRepository.save(actor).subscribe(result->{
			log.info("Actor saved "+result.getId());
			//Mono<Actor> actorResult = this.actorRepository.findById(result.getId());
		});

		//Mono<Actor> result = this.actorRepository.findById(actor.getId());
		WaitUtil.sleep(2000);
		
	}
}
