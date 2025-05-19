package com.BankingApplication.service;

import java.util.List;

import com.BankingApplication.dto.AccountDto;

public interface AccountService {
	
	
	AccountDto createAccount(AccountDto account);
	
	AccountDto getAccountById(Long id);
	

}

