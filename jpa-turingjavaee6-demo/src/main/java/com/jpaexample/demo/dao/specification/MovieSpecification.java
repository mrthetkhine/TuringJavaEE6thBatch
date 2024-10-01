package com.jpaexample.demo.dao.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.jpaexample.demo.model.entity.Actor;
import com.jpaexample.demo.model.entity.Movie;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder.In;

public class MovieSpecification {
	
	public static Specification<Movie> getMovieByYear(Long i) {
		return new Specification<Movie>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Movie> root,
					CriteriaQuery<?> query, 
					CriteriaBuilder cb) {
				return cb.equal(root.<Long>get("year"), i);
			}
			
		};  
	 }
	public static Specification<Movie> getMovieByYearBetween(Long start,Long end) {
		return new Specification<Movie>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Movie> root,
					CriteriaQuery<?> query, 
					CriteriaBuilder cb) {
				return cb.between(root.<Long>get("year"), start,end);
			}
			
		};  
	 }
	public static Specification<Movie> getMovieByTitleLike(String title) {
		return new Specification<Movie>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Movie> root,
					CriteriaQuery<?> query, 
					CriteriaBuilder cb) {
			
				Predicate pred= cb.like(root.<String>get("title"),"%"+title+"%");
				return pred;
			}
			
		};  
	 }
	public static Specification<Movie> getMovieByYearGreaterThan(Long i) {
		return new Specification<Movie>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Movie> root,
					CriteriaQuery<?> query, 
					CriteriaBuilder cb) {
				return cb.ge(root.<Long>get("year"), i);
			}
			
		};  
	 }
	public static Specification<Movie> getMovieByTitleOrYear(String title,Long year) {
		return new Specification<Movie>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Movie> root,
					CriteriaQuery<?> query, 
					CriteriaBuilder cb) {
				ArrayList<Predicate> predicates = new ArrayList<Predicate>();
				if(title != null)
				{
					predicates.add(cb.equal(root.get("title"), title));
				}
				if(year != null)
				{
					predicates.add(cb.equal(root.get("year"), year));
				}
				Predicate or = cb.or(predicates.toArray(new Predicate[] {}));
				
				query.where(or);
				return or;
			}
			
		};  
	 }
	public static Specification<Movie> getMovieByTitle(String title) {
	    return (root, query, builder) -> {
	      return builder.like(root.get("title"), "%"+title+"%");
	  };
	}
	public static Specification<Movie> getMovieWhereActorIn(String actor) {
	    return (root, query, builder) -> {
	    Join<Movie, Actor> actors = root.join("actors");
	    
	    return builder.equal(actors.get("name").get("fullName"), actor);
	  };
	}
	public static Specification<Movie> getMovieGroupByGenere(String genres) {
	    return (root, query, builder) -> {
	   
	    query.orderBy(builder.asc(root.get("genre")));
	    return query.getRestriction();
	   
	  };
	}
	public static Specification<Movie> getMovieInGenere(List<String> genres) {
	    return (root, query, builder) -> {
	    In<String> inClause = builder.in(root.get("genre"));	
	    for (String genre : genres) {
	        inClause.value(genre);
	    }
	    return inClause;
	  };
 }
}
