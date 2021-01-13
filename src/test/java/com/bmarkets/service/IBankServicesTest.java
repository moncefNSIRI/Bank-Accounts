package com.bmarkets.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bmarkets.BankAccountsApplication;
import com.bmarkets.dao.AccountRepository;
import com.bmarkets.dao.ClientRepository;
import com.bmarkets.dao.OperationRepository;
import com.bmarkets.entities.Account;
import com.bmarkets.entities.Client;
import com.bmarkets.entities.Operation;
import com.bmarkets.services.IBankServices;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankAccountsApplication.class)
class IBankServicesTest {

	
	@Autowired
	private ClientRepository cr;
	@Autowired
	private AccountRepository ar;
	@Autowired
	private OperationRepository or;;
	@Autowired
	IBankServices ibs;
	
	
	
	@Test
	void testDeosit() {
		Client  client =new Client("Fabien","fabienf@gmail.com");
		
		Client c01=cr.save(client);
		Account ac001 =ar.save(new Account("accnt100", new Date(), 0,c01));
		
		ibs.DepositAccount(ac001.getAccountCode(), 1000);
		
		Account retreivedAccount = ar.findByAccountCode("accnt100");
		
		assertThat(retreivedAccount.getBalance()==1000);
		
		
	}
	@Test
	void testWithdrawal() {
		Client  client =new Client("Fabien","fabienf@gmail.com");
		
		Client c01=cr.save(client);
		Account ac001 =ar.save(new Account("accnt100", new Date(), 1000,c01));
		
		ibs.WithdrawalAccount(ac001.getAccountCode(), 1000);
		
		Account retreivedAccount = ar.findByAccountCode("accnt100");
		
		assertThat(retreivedAccount.getBalance()==0);
		
		
	}
	
	@Test
	void testRetreiveOperations() {
		Client  client =new Client("Fabien","fabienf@gmail.com");
		
		Client c01=cr.save(client);
		Account ac001 =ar.save(new Account("accnt100", new Date(), 1000,c01));
		
		ibs.DepositAccount(ac001.getAccountCode(), 5000);
		ibs.WithdrawalAccount(ac001.getAccountCode(), 1000);
		
		 List<Operation> retreivedOperations =ibs.listOperation("accnt100",1,5).getContent();
		 List<Operation> expectededOperations = or.listOperations("accnt100", PageRequest.of(1, 5)).getContent();
		 
		
		assertThat(retreivedOperations.equals(expectededOperations));
		
		
	}
	
	@Test
	void testInvalidAmountOperation() {
		Assertions.assertThrows(Exception.class, () -> {	
			Client  client =new Client("Fabien","fabienf@gmail.com");
			
			Client c01=cr.save(client);
			Account ac001 =ar.save(new Account("accnt100", new Date(), 1000,c01));
			
			ibs.WithdrawalAccount(ac001.getAccountCode(), 5000);
		  });
		
		
	
		
		
		
		
	}

}
