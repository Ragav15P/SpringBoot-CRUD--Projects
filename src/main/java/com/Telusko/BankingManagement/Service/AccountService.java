package com.Telusko.BankingManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Telusko.BankingManagement.Entity.Account;
import com.Telusko.BankingManagement.Repo.AccountInterfaceRepo;
@Service
public class AccountService implements AccountInterface
{
	@Autowired
	private AccountInterfaceRepo obj;

	@Override
	public Account createAccount(Account Acc) 
	{

		Account account=obj.save(Acc);
		
		return account;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long AccountNumber) 
	{
		  Optional<Account> opt=obj.findById(AccountNumber);
		  if(opt.isEmpty())
		  {
			  throw new RuntimeException("Account Doesn't Exist  With Given Account Number");
		  }
		  
		return opt.get();
	}

	@Override
	public List<Account> getAllAccounts() 
	{
		
		return obj.findAll();
	}

	@Override
	public Account depositMoney(Long AccountNumber, Double Amount) 
	{
		Optional<Account>op=obj.findById(AccountNumber);
		if(op.isEmpty())
		{
			throw new RuntimeException("Account Doesn't Exists Invalid Account Number");
		}
		Account updated=op.get();
		Double curr_Balance=updated.getAccountBalance();
		Double updated_Balance=curr_Balance+Amount;
		updated.setAccountBalance(updated_Balance);
		obj.save(updated);
		return updated;
		
		
	}

	@Override
	public Account withdrawMoney(Long AccountNumber, Double Amount) 
	{
		
		Optional<Account>optional=obj.findById(AccountNumber);
		if(optional.isEmpty())
		{
			throw new RuntimeException("Account Number Doesn't Exists");
		}
		Account newOne=optional.get();
		Double curr_Balance=newOne.getAccountBalance();
		if(curr_Balance<Amount)
		{
			throw new RuntimeException("Insufficient Funds...........");
		}
		Double new_Balance=curr_Balance-Amount;
		newOne.setAccountBalance(new_Balance);
		obj.save(newOne);
		return newOne;
		
	}

	@Override
	public Double  checkBalance(Long AccountNumber) 
	{
		Optional<Account>opti=obj.findById(AccountNumber);
		if(opti.isEmpty())
		{
			throw new RuntimeException("Invalid AccountNumber");
		}
		Account det=opti.get();
		Double bal=det.getAccountBalance();
		return bal;
		
		
	}

	@Override
	public void closeAccount(Long AccountNumber) 
	{
		
		Optional<Account>opti=obj.findById(AccountNumber);
		if(opti.isEmpty())
		{
			throw new RuntimeException("Invalid AccountNumber");
		}
		obj.deleteById(AccountNumber);
	}

}
