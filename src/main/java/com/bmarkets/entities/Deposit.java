package com.bmarkets.entities;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
* The Deposit  class is used for representing specific bank operations
* It extends Operation abstract class
*/

@Entity
@DiscriminatorValue("D")
public class Deposit extends Operation{

	
	
	
	public Deposit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deposit(Date operationDate, double amount, Account account) {
		super(operationDate, amount, account);
		// TODO Auto-generated constructor stub
	}

	
}
