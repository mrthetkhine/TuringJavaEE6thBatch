package com.reactive.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Pair;

import com.reactive.demo.WaitUtil;
import com.reactive.demo.model.Movie;
import com.reactive.demo.model.Review;
import com.reactive.demo.repository.ReviewRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.util.function.Tuple2;

@Slf4j
@SpringBootTest
public class ReviewServiceTest {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Test
	public void testReviewWithAvgRating()
	{
		
		WaitUtil.delay(1000);
	}
}
