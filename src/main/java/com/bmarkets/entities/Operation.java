package com.bmarkets.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


/**
* The Operation  class is used for representing bank operations
* It's an abstract class containing commun properties between different types of operations 
*/

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "OP_TYPE",discriminatorType = DiscriminatorType.STRING,length = 1)
public abstract class Operation implements Serializable{


	
	private static final long serialVersionUID = 5156536052339305799L;
	@Id @GeneratedValue
	private long number;
	private Date operationDate;
	private double amount;
	
	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;
	
	
	
	
	public Operation() {
		
	}
	public Operation(Date operationDate, double amount, Account account) {
		super();
		this.operationDate = operationDate;
		this.amount = amount;
		this.account = account;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public Date getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
