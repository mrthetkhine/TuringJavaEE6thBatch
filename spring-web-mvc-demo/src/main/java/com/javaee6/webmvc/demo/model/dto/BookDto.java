package com.javaee6.webmvc.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDto {

	private Long id;

	@NotBlank(message = "{required.book.title}")
	@Size(min = 3, max = 100, message = "{size.book.title}")
	private String title;

	@NotBlank(message = "{required.book.author}")
	@Size(min = 3, max = 100, message = "{size.book.author}")
	private String author;

	@NotBlank(message = "{required.book.description}")
	@Size(min = 3, max = 100, message = "{size.book.description}")
	private String description;
}
