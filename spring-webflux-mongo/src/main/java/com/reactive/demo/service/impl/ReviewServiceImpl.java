package com.reactive.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.demo.common.Mapper;
import com.reactive.demo.dto.ReviewDto;
import com.reactive.demo.model.Review;
import com.reactive.demo.repository.MovieRepository;
import com.reactive.demo.repository.ReviewRepository;
import com.reactive.demo.service.ReviewService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	Mapper mapper;

	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public Flux<ReviewDto> getAllReview() {
		
		return this.reviewRepository
					.findAll()
					.map(review->this.mapper.map(review, ReviewDto.class));
	}

	@Override
	public Flux<ReviewDto> getReviewByMovie(String movieId) {
		return this.reviewRepository
					.findReviewByMovieId(movieId)
					.map(review->this.mapper.map(review, ReviewDto.class));
					
	}

	@Override
	public Mono<ReviewDto> saveReviewForMovie(ReviewDto reviewDto) {
		Review review = this.mapper.map(reviewDto, Review.class);
		
		return this.movieRepository
				.findById(reviewDto.getMovieId())
				.flatMap(movie->{	
					review.setMovie(movie);
					return this.reviewRepository.save(review);
				})
				.map(r->this.mapper.map(r, ReviewDto.class));
					
	}

	@Override
	public Mono<ReviewDto> updateReview(ReviewDto reviewDto) {
		
		return this.saveReviewForMovie(reviewDto);
	}

	@Override
	public Mono<ReviewDto> deleteReviewById(String reviewId) {
		return this.reviewRepository
					.findById(reviewId)
					.switchIfEmpty(Mono.error(new Exception("Review "+reviewId+ " not found")))
					.flatMap(review->{
						return this.reviewRepository
									.deleteById(reviewId)
									.thenReturn(this.mapper.map(review, ReviewDto.class));
									
					});
						
	}

}
