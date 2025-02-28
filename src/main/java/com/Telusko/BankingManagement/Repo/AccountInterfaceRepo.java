package com.Telusko.BankingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Telusko.BankingManagement.Entity.Account;
@Repository
public interface AccountInterfaceRepo extends JpaRepository<Account,Long>
{

}
