package com.BankingApplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.service.AccountService;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	private static final String Https = null;
	private AccountService accountService;
	
	
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
     
	
	// add account rest API
	@PostMapping
	public ResponseEntity<AccountDto> addAccount (@RequestBody AccountDto accountDto){
		
	    System.out.println(accountDto);
	   return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	
}
	//get account details
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		
		AccountDto accountDto=accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}
	//deposit rest API
	@PutMapping("{id}/deposit")
	public ResponseEntity<AccountDto> deposit (@PathVariable Long id, @RequestBody Map<String, Double> request){
		
	    Double amount=request.get("amount");
		AccountDto accountDto =  accountService.deposit(id, request.get("amount"));
		
		return ResponseEntity.ok(accountDto);
	}
	//withdraw 
	@PutMapping("{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw( @PathVariable Long id, @RequestBody Map<String,Double>request){
		double amount=request.get("amount");
		AccountDto accountDto= accountService.withdraw(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
	
	@GetMapping
	public ResponseEntity<List<AccountDto>>getAllAccounts(){
	   List<AccountDto> accountDto= accountService.getAllAccounts();
	   
	   return ResponseEntity.ok(accountDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteAccount(@PathVariable Long id){
		
		accountService.deleteAccount(id);
		
		return ResponseEntity.ok("Account deleted sucessfully !!");
		
	}
	
}
	

