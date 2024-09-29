package com.jpaexample.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.jpaexample.demo.dao.jpql.MovieHQLTest;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
//@Rollback(false)
public class MoneyTranserServiceTest {

	@Autowired
	MoneyTransferService transferService;
	
	@Test
	//@Transactional
	public void testTransfer()
	{
		try
		{
			this.transferService.sendMoney(1L, 2L, -1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
