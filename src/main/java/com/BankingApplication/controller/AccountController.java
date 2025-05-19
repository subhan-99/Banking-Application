package com.BankingApplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	private AccountService accountService;
	
	
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
     
	
	// add account rest api
	@PostMapping
	public ResponseEntity<AccountDto> addAccount (AccountDto accountDto){
		
	    System.out.println(accountDto);
	   return new  ResponseEntity<>(accountService.createAccount(accountDto))
	
}
	
	public ResponseEntity<AccountDto> getAccountById(Long id){
		AccountDto accountDto=accountService.getAccountById(id);
		
		return ResponseEntity.ok(accountDto);
	}
}
