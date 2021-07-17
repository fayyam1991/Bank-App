package com.india.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.india.bank.dto.ResponseEntity;
import com.india.bank.entity.Account;
import com.india.bank.repository.Accountrepository;

@Service
public class BankService {
	@Autowired
	private Accountrepository accountrepository;

	public ResponseEntity<Account> addAccount(Account account) {
		accountrepository.save(account);
		return new ResponseEntity<Account>("Account added successfully", account, HttpStatus.OK);
	}

	public ResponseEntity<Account> deleteAccount(String accountNo) {
		Account account = accountrepository.findByAccountNumber(accountNo);
		if (account != null) {
			accountrepository.delete(account);
			return new ResponseEntity<Account>("Account deleted successfully", account, HttpStatus.OK);
		}
		return new ResponseEntity<Account>("Account not found ", null, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Account> update(String accountNo, long balence) {
		Account account = accountrepository.findByAccountNumber(accountNo);
		if (account != null) {
			long currentBalence = account.getBalence();
			account.setBalence(currentBalence + balence);
			accountrepository.save(account);
			return new ResponseEntity<Account>("Account updated successfully", account, HttpStatus.OK);
		}
		return new ResponseEntity<Account>("Account not fount", account, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<List<Account>> getAccounts(String accountNo) {
		List<Account> accounts = new ArrayList<>();
		
		String message;

		if (!accountNo.isEmpty()) {
			Account account = accountrepository.findByAccountNumber(accountNo);
			if (account != null) {
				accounts.add(account);
				message = "Single Account";
			}else {
				return new ResponseEntity<List<Account>>("Not fount", accounts, HttpStatus.NOT_FOUND);
			}
		} else {
			accounts = accountrepository.findAll();
			message = "Multiple Accounts";

		}
		return new ResponseEntity<List<Account>>(message, accounts, HttpStatus.OK);

	}

}
