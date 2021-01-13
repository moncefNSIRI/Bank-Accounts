package com.bmarkets.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Client class is used for representing bank clients 
 */

@Entity
@Table(name="clientelle")
public class Client implements Serializable{
	
	private static final long serialVersionUID = -3378421409989531072L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clientId;
	
	private String clientName;
	
	private String clientEmail;
	
	
	
	
	public Client() {
		
	}

	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	private List<Account> clientAccounts;
	
	public Client(String clientName, String clientEmail) {
	
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public List<Account> getClientAccounts() {
		return clientAccounts;
	}

	public void setClientAccounts(List<Account> clientAccounts) {
		this.clientAccounts = clientAccounts;
	}
	
	
		

}
