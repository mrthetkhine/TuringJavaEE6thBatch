package com.jpaexample.demo.model.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;



@ToString
public class GenreCountDtoTwo {
	private String genre;
	private Long count;
	
	public GenreCountDtoTwo(String genre,Long count)
	{
		this.genre = genre;
		this.count = count;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
}
