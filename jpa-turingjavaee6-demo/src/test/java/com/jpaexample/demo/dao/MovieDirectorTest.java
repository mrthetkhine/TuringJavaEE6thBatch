package com.jpaexample.demo.dao;

import static org.assertj.core.api.Assertions.setExtractBareNamePropertyMethods;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.jpaexample.demo.model.entity.Director;
import com.jpaexample.demo.model.entity.Gender;
import com.jpaexample.demo.model.entity.Movie;
import com.jpaexample.demo.model.entity.Name;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
@Rollback(false)
public class MovieDirectorTest {
	@Autowired 
	MovieDao movieDao;
	
	@Test
	@Transactional
	void testCreate()
	{
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		Movie movie = this.movieDao.getById(4L);
		Director d1 = new Director();
		
		Name d1Name = new Name();
		d1Name.setFirstName("Director");
		d1Name.setLastName("Five");
		d1.setName(d1Name);
		d1.setBirthday(new Date());
		d1.setGender(Gender.Male);
		
		Director d2 = new Director();
		Name d2Name = new Name();
		d2Name.setFirstName("Director");
		d2Name.setLastName("Six");
		d2.setName(d2Name);
		
		LocalDate localDate = LocalDate.of(2015, 02, 20);
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		d2.setBirthday(date);
		d2.setGender(Gender.Male);
		
		movie.getDirectors().add(d1);
		movie.getDirectors().add(d2);
		
		this.movieDao.save(movie);
	}
	
}
