package com.reactive.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.demo.controller.service.MovieService;
import com.reactive.demo.dto.MovieDetailsDto;
import com.reactive.demo.dto.MovieDto;
import com.reactive.demo.dto.ActorDto;
import com.reactive.demo.model.MovieDetails;
import com.reactive.demo.repository.ActorRepositoryTest;
import com.reactive.demo.repository.WaitUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MovieServiceTest {
	@Autowired
	MovieService movieService;
	
	//@Test
	public void testGetAllMovies()
	{
		this.movieService.getAllMovie()
						 .subscribe(movie->{
							log.info("Movie" +movie);
							assertNotNull(movie.getName());
						 });
		WaitUtil.sleep(2000);
	}
	//@Test
	public void testFindMovieById()
	{
		String id ="67276be7973bc74a9cdcd916";
		this.movieService.getMovieById(id)
			.subscribe(movieDto->{
				log.info("Movie "+movieDto);
			},err->{
				log.info("Error "+err);
			});
		WaitUtil.sleep(2000);	
	}
	//@Test
	public void testSaveMovie()
	{
		MovieDto dto = new MovieDto();
		dto.setName("Movie 4");
		MovieDetailsDto details = new MovieDetailsDto();
		details.setDetails("Movie 4 details");
		
		dto.setDetails(details);
		
		dto.setDirector("Movie 4 Director");
		ArrayList<ActorDto> actors = new ArrayList<ActorDto>();
		
		ActorDto actorOne = new ActorDto();
		actorOne.setFirstName("Actor");
		actorOne.setLastName("of movie 3");
		
		//actors.add(actorOne);
		dto.setActors(actors);
		
		this.movieService.saveMovie(dto)
			.subscribe(result->{
				log.info("Saved movie"+result);
			});
		
		WaitUtil.sleep(2000);
	}
	@Test
	public void testUpdateMovie()
	{
		MovieDto dto = new MovieDto();
		dto.setName("Movie 4 Update");
		MovieDetailsDto details = new MovieDetailsDto();
		details.setDetails("Movie 4 details");
		
		dto.setDetails(details);
		
		dto.setDirector("Movie 4 Director");
		ArrayList<ActorDto> actors = new ArrayList<ActorDto>();
		
		ActorDto actorOne = new ActorDto();
		actorOne.setFirstName("Actor");
		actorOne.setLastName("of movie 3");
		
		//actors.add(actorOne);
		dto.setActors(actors);
		this.movieService.updateMovieById("67277c9665ddc339364aa0c8", dto)
			.subscribe(updatedMovie->{
				log.info("Updated movie"+updatedMovie);
				assertNotNull(updatedMovie);
			});
		WaitUtil.sleep(2000);
	}
}
