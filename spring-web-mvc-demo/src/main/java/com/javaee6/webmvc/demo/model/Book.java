package com.javaee6.webmvc.demo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book implements Serializable{
	
	Long id;
	String title;
	String author;
	String description;
}
