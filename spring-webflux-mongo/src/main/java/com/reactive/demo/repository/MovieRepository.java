package com.reactive.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.demo.model.Actor;
import com.reactive.demo.model.Movie;

import reactor.core.publisher.Flux;

public interface MovieRepository extends ReactiveMongoRepository<Movie,String>{
	Flux<Movie> findByYear(Long year);
	
	@Query("{ 'director' : ?0 }")
	Flux<Movie> getMovieByDirector(String director);
	
	@Query("{ 'year':{ '$gte' : ?0 }}")
	Flux<Movie> getMovieByYearGt(Long year);
	
	@Aggregation(pipeline={"{\n"
	 		+ "        $addFields: {\n"
	 		+ "            \"movie_actors\": {\n"
	 		+ "                $map:{\n"
	 		+ "                    input: \"$actors\",\n"
	 		+ "                    as: \"actor\",\n"
	 		+ "                    in: '$$actor.$id'\n"
	 		+ "                }\n"
	 		+ "                \n"
	 		+ "            }\n"
	 		+ "        }\n"
	 		+ "    },\n"
	 		,
	 		 "    {\n"
	 		+ "        $unwind : \"$movie_actors\" \n"
	 		+ "    },\n"
	 		,
	 		 "    { \n"
	 		+ "        \"$lookup\": {\n"
	 		+ "            \"from\": \"actors\",\n"
	 		+ "            \"localField\": \"movie_actors\",\n"
	 		+ "            \"foreignField\": \"_id\",\n"
	 		+ "            \"as\": \"joined_actors\"\n"
	 		+ "        } \n"
	 		+ "    }"
	 		,
	 		 "    { \n"
	 		+ "        \"$group\": {\n"
	 		+ "            \"_id\": \"$_id\",\n"
	 		+ "            \"joined_actors\":{ \n"
	 		+ "                                \"$push\":{ $arrayElemAt: [ \"$joined_actors\",0] }\n"
	 		+ "                            },\n"
	 		+ "            \"doc\":{\"$first\":\"$$ROOT\"}\n"
	 		+ "        }\n"
	 		+ "    }"
	 		,
	 		 "    {   \"$replaceRoot\":{\n"
	 		+ "            \"newRoot\":{ $mergeObjects: [ '$doc',{ actors: '$joined_actors' }] },\n"
	 		+ "        }\n"
	 		+ "    }"
	 		,
	 		" { $unset: \"joined_actors\" }"
	 		,
	 		 "     { \n"
	 		+ "        \"$match\": {\n"
	 		+ "            \"actors\": {\n"
	 		+ "                $elemMatch:{\n"
	 		+ "                    \"firstName\":?0"
	 		+ "                }\n"
	 		+ "            }\n"
	 		+ "        } \n"
	 		+ "    }"})
	 Flux<Movie> getAllMovieWithLookup(String actorName);
}
