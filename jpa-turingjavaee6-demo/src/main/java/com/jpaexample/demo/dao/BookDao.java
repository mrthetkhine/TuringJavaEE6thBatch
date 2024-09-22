package com.jpaexample.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpaexample.demo.model.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
	List<Book> findByYear(Long year);
	List<Book> findByYearAndTitle(Long year,String title);
	List<Book> findByYearOrTitle(Long year,String title);
	List<Book> findByYearGreaterThan(Long year);
	List<Book> findByYearGreaterThanEqual(Long year);
	List<Book> findByTitleLike(String title);
	List<Book> findByTitleStartingWith(String title);
	List<Book> findByAuthorOrderByYearDesc(String author);
	List<Book> findByYearIn(List<Long> years);
	
	//HQL, JPQL
	@Query("SELECT b from Book b where b.title = ?1")
	Book findByBookTitle(String title);
	
	//Native SQL
	@Query(value="SELECT * from Book b where b.title = ?1",nativeQuery=true)
	Book findByBookTitleWithNative(String title);

}
