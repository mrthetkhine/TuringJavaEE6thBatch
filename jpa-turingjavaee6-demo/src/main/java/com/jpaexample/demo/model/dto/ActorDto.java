package com.jpaexample.demo.model.dto;

import java.util.Date;

import org.hibernate.annotations.Formula;

import com.jpaexample.demo.model.entity.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ActorDto {

	private String firstName;
	private String lastName;
	private String fullName;
	private Date birthday;
	private Integer age;
	Gender gender;
}
