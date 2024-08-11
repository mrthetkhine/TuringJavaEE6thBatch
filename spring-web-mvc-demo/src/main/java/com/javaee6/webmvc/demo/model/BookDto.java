package com.javaee6.webmvc.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

	private Long id;
	private String title;
	private String author;
	private String description;
}
