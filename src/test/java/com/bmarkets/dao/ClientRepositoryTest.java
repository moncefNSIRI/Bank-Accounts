package com.bmarkets.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

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



@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankAccountsApplication.class)
class ClientRepositoryTest {
	
	@Autowired
	private ClientRepository cr;
	@Autowired
	private AccountRepository ar;
	
	

	@Test
	void testSaveClient() {
		
			Client  client =new Client("Moncef","moncef@gmail.com");			
			Client createdClient=cr.save(client);
			
			Client retreivedClient = cr.findByClientId(createdClient.getClientId());
			
			
			assertThat(createdClient.equals(retreivedClient));
	}
	
	void testRetreiveClient() {
		
		Client  client =new Client("Moncef","moncef@gmail.com");			
		Client createdClient=cr.save(client);
		
		ar.save(new Account("accnt09", new Date(), 0,createdClient)); 
		
		Client retreivedClient = ar.findByClient(createdClient).getClient();
		
		assertThat(createdClient.equals(retreivedClient));
}

}
