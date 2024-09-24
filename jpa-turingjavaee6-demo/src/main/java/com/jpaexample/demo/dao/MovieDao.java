package com.jpaexample.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpaexample.demo.model.dto.GenreCountDto;
import com.jpaexample.demo.model.dto.GenreCountDtoTwo;
import com.jpaexample.demo.model.dto.TitleAndGenre;
import com.jpaexample.demo.model.entity.Book;
import com.jpaexample.demo.model.entity.Movie;

@Repository
public interface MovieDao  extends JpaRepository<Movie, Long>{

	@Query(value="SELECT * FROM movie WHERE title=?",nativeQuery=true)
	Movie findMovieWithTitleInNative(String title);
	
	@Query("SELECT m FROM Movie m")
	List<Movie> getAllMovie();
	
	@Query("SELECT m.title As title,m.genre As genre FROM Movie m")
	List<TitleAndGenre> getAllTitleAndGenre();
	
	@Query(value="SELECT genre,count(*)As count "
			+ "FROM movie GROUP BY genre;",nativeQuery=true)
	List<GenreCountDto> getAllGeneresCount();
	
	@Query(value="SELECT new com.jpaexample.demo.model.dto.GenreCountDtoTwo( m.genre,count(m.genre)) "
			+ "FROM Movie m GROUP BY m.genre"
			)
	List<GenreCountDtoTwo> getAllGeneresCountV2();
	
	@Query("SELECT distinct(m.genre) FROM Movie m")
	List<String> getAllGenere();
	
	@Query("SELECT m FROM Movie m WHERE m.title LIKE %?1%")
	List<Movie> getAllMovieLike(String title);
	
	@Query("SELECT count(m) FROM Movie m "
			+ "WHERE m.genre = :genre")
	int findTotalMovieByGenres(@Param("genre") String genere);
	
	@Query("SELECT m FROM Movie m WHERE m.year>=?1")
	List<Movie> getAllMovieWithYearGTE(Integer year);
	
	@Query("SELECT m FROM Movie m WHERE m.year>=?1 AND m.genre like ?2")
	List<Movie> getAllMovieWithYearAndGenere(Integer year,String genre);
	
	@Query("SELECT m FROM Movie m WHERE m.year BETWEEN ?1 AND ?2")
	List<Movie> getAllMovieWithYearBetweeen(Integer from,Integer to);
}
