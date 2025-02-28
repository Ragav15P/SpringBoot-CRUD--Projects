package com.Telusko.BankingManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long accountNumber;
	private String accountHolder;
	private Double accountBalance;
	public Long getAccountNumber() 
	{
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) 
	{
		this.accountNumber = accountNumber;
	}
	public String getAccountHolder() 
	{
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) 
	{
		this.accountHolder = accountHolder;
	}
	public Double getAccountBalance() 
	{
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) 
	{
		this.accountBalance = accountBalance;
	}
	public Account(Long accountNumber, String accountHolder, Double accountBalance) 
	{
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.accountBalance = accountBalance;
	}
	public Account() 
	{
		super();
	}
	@Override
	public String toString() 
	{
		return "Account [accountNumber=" + accountNumber + ", accountHolder=" + accountHolder + ", accountBalance="
				+ accountBalance + "]";
	}
	
	
	
	
}
