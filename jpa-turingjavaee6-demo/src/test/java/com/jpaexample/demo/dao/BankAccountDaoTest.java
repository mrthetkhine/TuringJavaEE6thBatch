package com.jpaexample.demo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.jpaexample.demo.model.entity.BankAccount;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
//@DataJpaTest
@Rollback(false)
public class BankAccountDaoTest {

	@Autowired
	BankAccountDao bankAccountDao;
	
	@Transactional
	@Test 
	public void testCreateAccount()
	{
		BankAccount accountA = new BankAccount();
		accountA.setAccountName("Account A");
		accountA.setBalance(500L);
		
		this.bankAccountDao.save(accountA);
		
		BankAccount accountB = new BankAccount();
		accountB.setAccountName("Account B");
		accountB.setBalance(500L);
		
		this.bankAccountDao.save(accountB);
	}
	
}
