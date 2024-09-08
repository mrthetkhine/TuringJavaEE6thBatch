package com.javaee6.webmvc.demo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Book implements Serializable{
	@Id
	Long id;
	String title;
	String author;
	String description;
}
