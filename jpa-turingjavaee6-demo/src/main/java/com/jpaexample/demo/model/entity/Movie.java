package com.jpaexample.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.ToString;


@ToString(callSuper=true)
@Data
@Entity
public class Movie extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column
	private String title;

	@Column//(nullable = false)
	private Integer year;

	@Column
	private String genre;
	
	@Transient
	private String something;
}
