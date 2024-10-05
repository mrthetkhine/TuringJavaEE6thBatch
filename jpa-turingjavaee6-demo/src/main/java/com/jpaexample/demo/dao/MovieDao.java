package com.jpaexample.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpaexample.demo.model.dto.GenreCountDto;
import com.jpaexample.demo.model.dto.GenreCountDtoTwo;
import com.jpaexample.demo.model.dto.TitleAndGenre;
import com.jpaexample.demo.model.entity.Book;
import com.jpaexample.demo.model.entity.Movie;

import jakarta.transaction.Transactional;

@Repository
public interface MovieDao  extends JpaRepository<Movie, Long>,JpaSpecificationExecutor<Movie>
{

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
	
	@Query("SELECT m FROM Movie m join m.actors actors WHERE actors.firstName LIKE %?1% AND actors.lastName LIKE %?2%")
	List<Movie> getMovieWithActorIn(String firstName, String lastName);
	
	
	
	@Query("SELECT m FROM Movie m join m.actors actors WHERE actors.firstName LIKE %?1%")
	List<Movie> getMovieWithActorWithFristNameIn(String firstName);
	
	@Query("SELECT m FROM Movie m join m.comments comments")
	List<Movie> getMovieWithComments();
	
	@Query("SELECT m FROM Movie m join m.comments comments WHERE comments.comment LIKE ?1")
	List<Movie> getMovieWithCommentIn(String comment);
	
	@Query("SELECT m FROM Movie m  WHERE m.movieDetails.details LIKE ?1")
	List<Movie> getMovieWithDetailPath(String details);
	
	@Query("SELECT m FROM Movie m left join m.comments comments")
	List<Movie> getMovieWithCommentsLeftJoin();
	
	@Query("SELECT m FROM Movie m order by m.title desc")
	List<Movie> getMovieOrderByTitle();
	
	@Modifying
	@Transactional
	@Query("INSERT Movie(title) VALUES (?1),(?2)")
	int insertTwoMovie(String title1, String title2);
	
}
