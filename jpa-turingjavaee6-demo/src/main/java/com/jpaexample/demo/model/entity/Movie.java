package com.jpaexample.demo.model.entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@ToString(callSuper=true)
@Data
@EqualsAndHashCode(exclude="movieDetails")
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
	
	@OneToOne(optional=false,
			mappedBy = "movie", 
			cascade = CascadeType.ALL,
			fetch=FetchType.LAZY)
	MovieDetails movieDetails;

	@OneToMany(
			cascade= CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.LAZY 
			)
	@JoinColumn(name="movie_id")
	List<Comment> comments = new ArrayList<>();
	
	@ManyToMany(
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	@JoinTable(name="actor_in_movie",
			joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") })
	List<Actor> actors=new ArrayList<>();

	@ManyToMany(
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL
			)
	@JoinTable(name="director_in_movie",
			joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "director_id") })
	List<Director> directors=new ArrayList<>();
}
