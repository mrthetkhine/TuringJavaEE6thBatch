package com.reactive.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {
	@Id
    private String id;
	
	@DBRef
	Movie movie;
	
	String review;
	Integer rating;
}
