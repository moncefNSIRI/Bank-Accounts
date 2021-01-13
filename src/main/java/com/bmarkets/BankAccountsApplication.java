package com.bmarkets;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmarkets.dao.AccountRepository;
import com.bmarkets.dao.ClientRepository;
import com.bmarkets.dao.OperationRepository;
import com.bmarkets.entities.Account;
import com.bmarkets.entities.Client;
import com.bmarkets.entities.Deposit;
import com.bmarkets.entities.Operation;
import com.bmarkets.entities.Withdrawal;
import com.bmarkets.security.SecurityConfig;
import com.bmarkets.services.IBankServices;



@Configuration
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages ={"com.bmarkets.entities","com.bmarkets.dao","com.bmarkets.servicesImpl","com.bmarkets.services","com.bmarkets.controller","com.bmarkets.security"})
public class BankAccountsApplication  implements CommandLineRunner {

	
	@org.springframework.beans.factory.annotation.Autowired(required=true)
	ClientRepository clientRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	IBankServices ibankservices;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(BankAccountsApplication.class, args);
	}

	

	@Override
	public void run(String... args) throws Exception {
		//Create 1 client to test application
		Client c1 = clientRepository.save(new Client("Moncef.NSIRI", "Moncef.NSIRI17@gmail.com"));		
		
		
		//Create  2 accounts for client Alex.DEGROUX
		  Account ac1 =accountRepository.save(new Account("accnt1", new Date(), 0,c1)); 
		  Account ac2 =accountRepository.save(new Account("accnt2", new Date(),1500, c1));
		  
		  
		  //Make some operations for client accounts
		  ibankservices.DepositAccount("accnt1", 750);
		  ibankservices.DepositAccount("accnt1", 200);
		  ibankservices.WithdrawalAccount("accnt1", 120);
		  ibankservices.WithdrawalAccount("accnt1", 120);
		  ibankservices.DepositAccount("accnt1", 2000);
		  ibankservices.WithdrawalAccount("accnt1", 120);
		  ibankservices.WithdrawalAccount("accnt1", 120);
		  
		  
		  ibankservices.WithdrawalAccount("accnt2", 120);
		  ibankservices.DepositAccount("accnt2", 500);	
		  ibankservices.DepositAccount("accnt2", 250);	
		  ibankservices.WithdrawalAccount("accnt2", 124);	
		  ibankservices.DepositAccount("accnt2", 5000);	
		  ibankservices.DepositAccount("accnt2", 40);
		  ibankservices.DepositAccount("accnt2", 600);	
		  ibankservices.DepositAccount("accnt2", 250);
			       
		
	}
}
