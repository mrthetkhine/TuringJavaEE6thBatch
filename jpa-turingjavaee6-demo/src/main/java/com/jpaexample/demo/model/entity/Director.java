package com.jpaexample.demo.model.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
public class Director extends Human{

	private static final long serialVersionUID = 1L;
	@ToString.Exclude
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, 
				cascade= {
						CascadeType.MERGE,
						CascadeType.PERSIST
				},
				mappedBy = "directors")
	private Set<Movie> movies = new HashSet<>();
}
