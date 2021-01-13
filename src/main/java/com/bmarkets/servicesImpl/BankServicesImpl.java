package com.bmarkets.servicesImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmarkets.dao.AccountRepository;
import com.bmarkets.dao.ClientRepository;
import com.bmarkets.dao.OperationRepository;
import com.bmarkets.entities.Account;
import com.bmarkets.entities.Deposit;
import com.bmarkets.entities.Operation;
import com.bmarkets.entities.Withdrawal;
import com.bmarkets.services.IBankServices;


@Service
@Transactional
public class BankServicesImpl implements IBankServices{

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public Account retreiveAccount(String accountCode) {
		
		
			Account ac=accountRepository.findByAccountCode(accountCode);
			if (ac==null) throw new RuntimeException("Account not found");
			return ac;
		
			
		}


	@Override
	public void DepositAccount(String accountCode, double amount) {
		Account ac=retreiveAccount(accountCode);
		//if (amount.matches("-?\\d+(\\.\\d+)?")) throw new RuntimeException("Insufficient balance");
		System.out.println(amount);
		Operation deposit= new Deposit(new Date(), amount, ac);
		operationRepository.save(deposit);
		ac.setBalance(ac.getBalance()+amount);
		accountRepository.save(ac);
	}

	@Override
	public void WithdrawalAccount(String accountCode, double amount) {

		Account ac=retreiveAccount(accountCode);
		if (ac.getBalance()<amount) throw new RuntimeException("Insufficient balance");
		
		Withdrawal withdrawal= new Withdrawal(new Date(), amount, ac);
		operationRepository.save(withdrawal);
		ac.setBalance(ac.getBalance()-amount);
		accountRepository.save(ac);
		
	}


	@Override
	public Page<Operation> listOperation(String accountCode, int page, int size) {
		// TODO Auto-generated method stub
		return operationRepository.listOperations(accountCode,PageRequest.of(page, size));
	}

}
