package com.bmarkets.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmarkets.entities.Account;
import com.bmarkets.entities.Client;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
	public Account findByAccountCode(String accountCode);
	public Account findByClient(Client accountClient);
	

}
