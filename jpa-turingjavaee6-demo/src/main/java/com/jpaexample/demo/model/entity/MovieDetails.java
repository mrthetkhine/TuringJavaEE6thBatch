package com.jpaexample.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class MovieDetails extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Column
	String details;
	
	@JsonIgnore
	@ToString.Exclude
	@OneToOne(fetch = FetchType.LAZY
			,cascade=CascadeType.ALL
			)
	@JoinColumn(name = "movie_id")
	private Movie movie;

}
