package com.jpaexample.demo.model.dto;

import java.util.List;
import java.util.Set;

import com.jpaexample.demo.model.entity.MovieDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MovieDto {
	
	Long id;
	
	@NotBlank(message = "{required.movie.title}")
	@Size(min = 3, max = 100, message = "{size.movie.title}")
	String title;
	
	@NotNull(message = "{required.movie.year}")
	private Integer year;
	
	@NotBlank(message = "{required.movie.genre}")
	private String genre;
	
	@NotNull(message = "{required.movie.movieDetails}")
	MovieDetailsDto movieDetails;
	
	List<CommentDto> comments;
	Set<ActorDto> actors;
	List<DirectorDto> directors;
}
