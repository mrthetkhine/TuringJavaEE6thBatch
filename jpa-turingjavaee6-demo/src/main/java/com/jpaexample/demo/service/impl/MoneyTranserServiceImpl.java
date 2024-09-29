package com.jpaexample.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexample.demo.dao.BankAccountDao;
import com.jpaexample.demo.model.dto.FinancialException;
import com.jpaexample.demo.model.entity.BankAccount;
import com.jpaexample.demo.service.MoneyTransferService;

import jakarta.transaction.Transactional;

@Service
public class MoneyTranserServiceImpl implements MoneyTransferService{

	@Autowired
	BankAccountDao bankAccountDao;
	
	@Transactional(rollbackOn = { FinancialException.class })
	@Override
	public void sendMoney(Long fromAccount, Long toAccount, Integer amount)throws FinancialException,Exception {
		
		this.debit(fromAccount, amount);
		this.credit(toAccount, amount);
		
	}
	
	void debit(Long fromAccount,Integer amount) throws Exception,FinancialException
	{
		Optional<BankAccount> result = this.bankAccountDao.findById(fromAccount);
		if(result.isPresent())
		{
			BankAccount account = result.get();
			if(account.getBalance()>= amount)
			{
				account.setBalance( account.getBalance()-amount);
				this.bankAccountDao.save(account);
			}
			else
			{
				throw new FinancialException("Invalid debit amount");
			}
			
		}
		else
		{
			throw new Exception("Invalid account");
		}
	}
	void credit(Long fromAccount,Integer amount) throws Exception,FinancialException
	{
		Optional<BankAccount> result = this.bankAccountDao.findById(fromAccount);
		if(result.isPresent())
		{
			BankAccount account = result.get();
			
			if(amount >0)
			{
				account.setBalance( account.getBalance()+amount);
				this.bankAccountDao.save(account);
			}
			else
			{
				throw new FinancialException("Invalid credit amount");
			}
		}
		else
		{
			throw new Exception("Invalid account");
		}
	}

}
