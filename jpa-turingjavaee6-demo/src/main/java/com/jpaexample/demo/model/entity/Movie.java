package com.jpaexample.demo.model.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
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
	private MovieDetails movieDetails;

	@OneToMany(
			cascade= CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.LAZY 
			)
	@JoinColumn(name="movie_id")
	private List<Comment> comments = new ArrayList<>();
	
	@ManyToMany(
			fetch=FetchType.LAZY
			,cascade= {
					CascadeType.MERGE,
					CascadeType.PERSIST
			})
	@JoinTable(name="actor_in_movie",
			joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") })
	private Set<Actor> actors = new HashSet<>();

	@ManyToMany(
			fetch=FetchType.LAZY,
			cascade= {
					CascadeType.MERGE,
					CascadeType.PERSIST
			}
			)
	@JoinTable(name="director_in_movie",
			joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "director_id") })
	private Set<Director> directors=new HashSet<>();

	
	
	
}
