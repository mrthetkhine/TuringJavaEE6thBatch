package com.reactive.demo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.demo.dto.ActorDto;
import com.reactive.demo.repository.WaitUtil;
import com.reactive.demo.service.ActorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ActorServiceTest {
	@Autowired
	ActorService actorService;
	
	
	//@Test
	public void testGetAllActor()
	{
		this.actorService.getAllActor()
									.doOnNext(actor->{
										log.info("Actor "+actor);
									})
									.collectList()
									.subscribe(data->{
										assertTrue(data.size()>0);
									});
		WaitUtil.sleep(2000);
	}
	//@Test
	public void saveActorTest()
	{
		ActorDto actor = new ActorDto();
		actor.setFirstName("Actor");
		actor.setLastName("Six");
		this.actorService.saveActor(actor)
									.subscribe(data->{
										log.info("Saved Actor "+data);
										assertTrue(data.getId()!=null);
									});
		WaitUtil.sleep(2000);
	}
	//@Test
	public void testActorUpdate()
	{
		String actorId = "672a2184ad234c333f63bebb";
		ActorDto actor = new ActorDto();
		actor.setFirstName("Actor");
		actor.setLastName("Six Updated");
		this.actorService.updateActorById(actorId,actor)
									.subscribe(data->{
										log.info("Updated Actor "+data);
										assertTrue(data.getLastName().equals("Six Updated"));
									});
		WaitUtil.sleep(2000);
	}
	@Test
	public void testDeleteActor()
	{
		String actorId = "672a2184ad234c333f63bebb";
		ActorDto actor = new ActorDto();
		actor.setFirstName("Actor");
		actor.setLastName("Six Updated");
		this.actorService.deleteActorById(actorId)
									.subscribe(data->{
										log.info("Updated Actor "+data);
										assertTrue(data.getLastName().equals("Six Updated"));
									});
		WaitUtil.sleep(2000);
	}
}
