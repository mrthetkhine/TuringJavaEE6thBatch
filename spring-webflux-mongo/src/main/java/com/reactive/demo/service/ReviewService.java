package com.reactive.demo.service;

import com.reactive.demo.dto.ReviewDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewService {
	Flux<ReviewDto> getAllReview();
	Flux<ReviewDto> getReviewByMovie(String movieId);
	Mono<ReviewDto> saveReviewForMovie(ReviewDto reviewDto);
	Mono<ReviewDto> updateReview(ReviewDto reviewDto);
	Mono<ReviewDto> deleteReviewById(String reviewId);
}
