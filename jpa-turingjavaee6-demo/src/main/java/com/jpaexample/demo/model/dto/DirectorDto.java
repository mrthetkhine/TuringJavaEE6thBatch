package com.jpaexample.demo.model.dto;

import java.util.Date;

import com.jpaexample.demo.model.entity.Gender;

import lombok.Data;

@Data
public class DirectorDto {
	private String firstName;
	private String lastName;
	private String fullName;
	private Date birthday;
	private Integer age;
	Gender gender;
}
