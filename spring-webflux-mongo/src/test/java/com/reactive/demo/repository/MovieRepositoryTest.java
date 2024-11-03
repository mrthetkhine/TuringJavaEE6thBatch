package com.reactive.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.demo.model.Movie;
import com.reactive.demo.model.MovieDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MovieRepositoryTest {
	
	@Autowired
	ActorRepository actorRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Test
	public void testSaveMovie()
	{
		//Titanic
		String leonardoId ="67262e9b07db71315210f56b";
		String kateId = "67262f32af73e55bebab3ec1";
		
		ArrayList<String> ids = new ArrayList<>();
		ids.add(leonardoId);
		//ids.add(kateId);
		
		ArrayList<String> genres =new ArrayList<>();
		genres.add("Drama");
		genres.add("History");
		
		Movie movie = new Movie();
		movie.setName("Inception");
		movie.setGenres(genres);
		
		MovieDetails  movieDetails =new MovieDetails();
		movieDetails.setDetails("This is Inception movie");
		movie.setDetails(movieDetails);
		
		movie.setDirector("Director of Inception");
		
		this.actorRepository.findAllById(ids)
							.collectList()
							.flatMap(actors->{
								movie.setActors(actors);
								return this.movieRepository.save(movie);
							})
							.subscribe(savedMovie->{
								log.info("Movie saved"+savedMovie);
								assertEquals(1,savedMovie.getActors().size());
							});
		WaitUtil.sleep(2000);
	}

}
