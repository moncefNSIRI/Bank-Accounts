package com.bmarkets.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bmarkets.BankAccountsApplication;
import com.bmarkets.dao.AccountRepository;
import com.bmarkets.dao.ClientRepository;
import com.bmarkets.entities.Account;
import com.bmarkets.entities.Client;
import com.bmarkets.services.IBankServices;

import junit.framework.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankAccountsApplication.class)
class AccountRepositoryTest {

	@Autowired
	private ClientRepository cr;
	@Autowired
	private AccountRepository ar;
	
	

	
	@Test
	void testCreateAccount() {
		Client  client =new Client("Moncef","moncef@gmail.com");
		
		Client c=cr.save(client);
		Account ac1 =ar.save(new Account("accnt09", new Date(), 0,c)); 
		
		
		Account retreivedAccount = ar.findByClient(c);
		assertThat(retreivedAccount.equals(ac1));
		
	}
	
	@Test
	void testRetreiveAccount() {
		Client  client =new Client("Jacques","moncef@gmail.com");
		
		Client c1=cr.save(client);
		Account ac01 =ar.save(new Account("accnt10", new Date(), 0,c1)); 
		
		
		
		Account retreivedAccount = ar.findByAccountCode(ac01.getAccountCode());
		assertThat(retreivedAccount.equals(ac01));
		
	}

}
