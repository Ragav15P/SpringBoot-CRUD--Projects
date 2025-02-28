package com.Telusko.BankingManagement.Service;

import java.util.List;

import com.Telusko.BankingManagement.Entity.Account;

public interface AccountInterface 
{
   public Account createAccount(Account Acc);
   public Account getAccountDetailsByAccountNumber(Long AccountNumber);
   public List<Account> getAllAccounts();
   public Account depositMoney(Long AccountNumber,Double Amount);
   public Account withdrawMoney(Long AccountNumber,Double Amount);
   public Double  checkBalance(Long AccountNumber);
   public void closeAccount(Long AccountNumber);
}
