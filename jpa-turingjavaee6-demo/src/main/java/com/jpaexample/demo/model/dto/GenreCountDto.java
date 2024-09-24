package com.jpaexample.demo.model.dto;

import org.springframework.beans.factory.annotation.Value;

public interface GenreCountDto {
	String getGenre();
	Integer getCount();
	
	@Value("#{target.genre.toUpperCase()}")
    String getGenreUpperCase();
}
