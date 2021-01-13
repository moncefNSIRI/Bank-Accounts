package com.bmarkets.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * The Account class is used for bank accounts 
 */

@Entity
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2817847019607990867L;
	@Id
	private String accountCode;
	private Date creationDate;
	private double balance;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	@OneToMany(mappedBy = "account")
	private List<Operation> operations;
	
	
	
	
	public Account() {
		
	}

	public Account(String accountCode, Date creationDate, double balance, Client client) {
		super();
		this.accountCode = accountCode;
		this.creationDate = creationDate;
		this.balance = balance;
		this.client = client;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	

}
