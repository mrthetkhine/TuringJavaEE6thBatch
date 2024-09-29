package com.jpaexample.demo.dao.specification;

import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.jpaexample.demo.model.entity.Movie;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

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
}
