package com.javaee6.webmvc.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TodoDto {
	Long userId;
	Long id;
	String title;
	Boolean completed;
}
