package com.bmarkets.entities;



import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
* The Withdrawal  class is used for representing specific bank operations 
* It extends Operation abstract class
*/

@Entity
@DiscriminatorValue("W")
public class Withdrawal extends Operation{

	
	
	public Withdrawal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Withdrawal(Date operationDate, double amount, Account account) {
		super(operationDate, amount, account);
		// TODO Auto-generated constructor stub
	}

}
