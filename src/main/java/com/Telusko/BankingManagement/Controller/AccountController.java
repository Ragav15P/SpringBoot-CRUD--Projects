package com.Telusko.BankingManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Telusko.BankingManagement.Entity.Account;
import com.Telusko.BankingManagement.Service.AccountService;

@RestController
public class AccountController 
{
	@Autowired
	private AccountService accountService;
	@PostMapping("/create")
      public ResponseEntity<Account> createAccount(@RequestBody Account acc)
      {
		
		Account ac=accountService.createAccount(acc);
    	  return ResponseEntity.status(HttpStatus.CREATED).body(ac);
      }
	@GetMapping("/accountNumber/{AccountNumber}")
	public Account getAccountDetailsByAccountNumber(@PathVariable Long AccountNumber)
	{
		return accountService.getAccountDetailsByAccountNumber(AccountNumber);
	}
	@GetMapping("/getAllAccounts")
	public List<Account> listAllAccounts()
	{
		return accountService.getAllAccounts()	;
	}
	@PutMapping("/deposit/{AccountNumber}/{money}")
	public Account depositMoney(@PathVariable Long AccountNumber,@PathVariable Double money)
	{
		Account acc=accountService.depositMoney(AccountNumber, money);
		return acc;
	}
	@PutMapping("/withdraw/{AccountNumber}/{Money}")
	public Account withDrawMoney(@PathVariable Long AccountNumber,@PathVariable Double Money)
	{
		Account ac=accountService.withdrawMoney(AccountNumber, Money);
		return ac;
	}
	@DeleteMapping("/delete/{AccountNumber}")
	public ResponseEntity<String> closeAccount(@PathVariable Long AccountNumber)
	{
		accountService.closeAccount(AccountNumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account Closed");
	}
	@GetMapping("/checkBalance/{AccountNumber}")
	public Double checkBalance(@PathVariable Long AccountNumber)
	{
		Double bal=accountService.checkBalance(AccountNumber);
		return bal;
	}
	
	
}
