package com.jpaexample.demo.service;

import com.jpaexample.demo.model.dto.FinancialException;

public interface MoneyTransferService {
	void sendMoney(Long fromAccount, Long toAccount, Integer amount) throws FinancialException,Exception;
}
