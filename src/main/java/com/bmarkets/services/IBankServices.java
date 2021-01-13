package com.bmarkets.services;

import org.springframework.data.domain.Page;

import com.bmarkets.entities.Account;
import com.bmarkets.entities.Operation;

public interface IBankServices {
	
	public Account retreiveAccount(String accountCode);
	public void DepositAccount(String accountCode,double amount);
	public void WithdrawalAccount(String accountCode,double amount);
	public Page<Operation> listOperation(String accountCode,int page,int size);

}
