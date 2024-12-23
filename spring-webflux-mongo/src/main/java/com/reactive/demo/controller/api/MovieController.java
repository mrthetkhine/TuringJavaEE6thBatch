package com.reactive.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.demo.common.ResponseUtil;
import com.reactive.demo.dto.MovieDto;
import com.reactive.demo.dto.RestResponse;
import com.reactive.demo.dto.ReviewDto;
import com.reactive.demo.service.MovieService;
import com.reactive.demo.service.ReviewService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	@Autowired
	ResponseUtil responseUtil;
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping
	Mono<ResponseEntity<RestResponse>>getAllMovies()
	{
		return this.movieService.getAllMovie()
								.collectList()
								.flatMap(movies->responseUtil.succesResponse(HttpStatus.OK,"Get all movies ok",movies));
							
	}
	@GetMapping("/{movieId}")
	Mono<ResponseEntity<RestResponse>> getMovieById(@PathVariable String movieId)
	{
		return this.movieService.getMovieById(movieId)
								.flatMap(movieDto->responseUtil.succesResponse(HttpStatus.OK,"Movie found successfully",movieDto))
								.onErrorResume(err->responseUtil.errorResponse(HttpStatus.BAD_REQUEST,err.getMessage(),err.getLocalizedMessage()));
							
	}
	
	@PostMapping
	Mono<ResponseEntity<RestResponse>> saveMovie(@Valid @RequestBody MovieDto dto)
	{
		return this.movieService.saveMovie(dto)
								.flatMap(movieDto->responseUtil.succesResponse(HttpStatus.CREATED,"Movie saved successfully",movieDto));							
		
	}
	@PutMapping("/{movieId}")
	Mono<ResponseEntity<RestResponse>> updateMovieById(@PathVariable String movieId, @Valid @RequestBody MovieDto movieDto)
	{
		return this.movieService.updateMovieById(movieId, movieDto)
								.flatMap(dto->responseUtil.succesResponse(HttpStatus.OK,"Movie update successfully",dto))
								.onErrorResume(err->responseUtil.errorResponse(HttpStatus.BAD_REQUEST,err.getMessage(),err.getLocalizedMessage()));
							
	}
	
	@DeleteMapping("/{movieId}")
	Mono<ResponseEntity<RestResponse>> deleteMovieById(@PathVariable String movieId)
	{
		return this.movieService.deleteMovieById(movieId)
								
								.flatMap(dto->responseUtil.succesResponse(HttpStatus.OK,"Movie deleted successfully",dto))
								.onErrorResume(err->responseUtil.errorResponse(HttpStatus.BAD_REQUEST,err.getMessage(),err.getLocalizedMessage()));
							
	}
	
	@GetMapping("/{movieId}/reviews")
	Mono<ResponseEntity<RestResponse>> getReviewsOfMovieId(@PathVariable String movieId)
	{
		return this.reviewService.getReviewByMovie(movieId)
								.collectList()	
								.flatMap(reviewDtos->responseUtil.succesResponse(HttpStatus.OK,"Review found successfully",reviewDtos))
								.onErrorResume(err->responseUtil.errorResponse(HttpStatus.BAD_REQUEST,err.getMessage(),err.getLocalizedMessage()));
							
	}
	@PostMapping("/{movieId}/reviews")
	Mono<ResponseEntity<RestResponse>> saveReview(@PathVariable String movieId,@Valid @RequestBody ReviewDto reviewDto)
	{
		reviewDto.setMovieId(movieId);
		return this.reviewService.saveReviewForMovie(reviewDto)
								.flatMap(dto->responseUtil.succesResponse(HttpStatus.OK,"Review successfully saved",dto))
								.onErrorResume(err->responseUtil.errorResponse(HttpStatus.BAD_REQUEST,err.getMessage(),err.getLocalizedMessage()));
							
	}
	@PutMapping("/reviews/{reviewId}")
	Mono<ResponseEntity<RestResponse>> updateReivew(@PathVariable String reviewId,@Valid @RequestBody ReviewDto reviewDto)
	{
		reviewDto.setId(reviewId);
		return this.reviewService.updateReview(reviewDto)
								.flatMap(dto->responseUtil.succesResponse(HttpStatus.OK,"Review successfully updated",dto))
								.onErrorResume(err->responseUtil.errorResponse(HttpStatus.BAD_REQUEST,err.getMessage(),err.getLocalizedMessage()));
							
	}
	@DeleteMapping("/reviews/{reviewId}")
	Mono<ResponseEntity<RestResponse>> deleteReview(@PathVariable String reviewId)
	{
		
		return this.reviewService.deleteReviewById(reviewId)
								.flatMap(dto->responseUtil.succesResponse(HttpStatus.OK,"Review successfully updated",dto))
								.onErrorResume(err->responseUtil.errorResponse(HttpStatus.BAD_REQUEST,err.getMessage(),err.getLocalizedMessage()));
							
	}
	
}
