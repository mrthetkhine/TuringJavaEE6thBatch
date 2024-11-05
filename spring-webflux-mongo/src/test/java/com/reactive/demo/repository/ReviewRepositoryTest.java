package com.reactive.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.demo.model.Review;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@SpringBootTest
public class ReviewRepositoryTest {
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Test
	public void testSaveReviewToMovie()
	{
		String movieId = "67277c77109fcd18f8eb9ef1";
		
		this.movieRepository.findById(movieId)
							.flatMap(movie->{
								
								Review review =new Review();
								review.setMovie(movie);
								review.setRating(5);
								review.setReview("Best movie ");
								return this.reviewRepository.save(review);
							})
							.subscribe(savedReview->{
								log.info("Review "+savedReview);
								assertEquals(5,savedReview.getRating());
							});
		WaitUtil.sleep(2000);
	}
	//@Test
	public void testSaveToUnexistingMovie()
	{
		String movieId = "67276be7973bc74a9cdcd916";
		
		this.movieRepository.findById(movieId)
				//.switchIfEmpty(Mono.just(null))
		
				/*
				.flatMap(movie->{
					log.info("Movie found "+movie );
					Review review =new Review();
					review.setMovie(movie);
					review.setRating(5);
					review.setReview("best movie ");
					return this.reviewRepository.save(review);
				})*/
				.subscribe(savedReview->{
					log.info("Review "+savedReview);
					//assertEquals(5,savedReview.getRating());
				});
		WaitUtil.sleep(2000);
							
	}
	//@Test
	public void getAllReviewByMovieId()
	{
		String movieId = "67276be7973bc74a9cdcd915";
		this.reviewRepository.findReviewByMovieId(movieId)
							 .doOnNext(review->{
								 log.info("Review "+review);
							 })
							 .collectList()
							 .subscribe(review->{
								 assertTrue(review.size()>0);
							 },err->{
								log.info("Err "+err.getMessage()); 
							 });
							 
		WaitUtil.sleep(2000);
	}
}
