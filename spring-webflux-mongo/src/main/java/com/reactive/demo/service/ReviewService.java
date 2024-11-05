package com.reactive.demo.service;

import com.reactive.demo.dto.ReviewDto;

import reactor.core.publisher.Flux;

public interface ReviewService {
	Flux<ReviewDto> getAllReview();
	Flux<ReviewDto> getReviewByMovie(String movieId);
}
