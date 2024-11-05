package com.reactive.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.demo.common.Mapper;
import com.reactive.demo.dto.ReviewDto;
import com.reactive.demo.repository.ReviewRepository;
import com.reactive.demo.service.ReviewService;

import reactor.core.publisher.Flux;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	Mapper mapper;

	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	public Flux<ReviewDto> getAllReview() {
		
		return this.reviewRepository
					.findAll()
					.map(review->this.mapper.map(review, ReviewDto.class));
	}

	@Override
	public Flux<ReviewDto> getReviewByMovie(String movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
