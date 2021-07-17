package com.india.bank.service;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.india.bank.dto.ResponseEntity;
import com.india.bank.dto.TransferEntity;
import com.india.bank.entity.Account;
import com.india.bank.repository.Accountrepository;
import com.india.bank.validation.AccountValidation;

@Service
@Transactional
public class balenceTransferService {

	@Autowired
	private Accountrepository accountrepository;

	public ResponseEntity<Map<String, Account>> transferBalence(TransferEntity transferEntity) {

		String fromAccountNo = transferEntity.getFromAccount();
		String toAccountNo = transferEntity.getToAccount();

		long ammount = transferEntity.getAmmount();

		Account fromAccount = accountrepository.findByAccountNumber(fromAccountNo);
		Account toAccount = accountrepository.findByAccountNumber(toAccountNo);

		if (fromAccount == null || toAccount == null) {
			return new ResponseEntity<Map<String, Account>>("Account Not Found", null, HttpStatus.NOT_FOUND);
		}

		long toAccountBalence = toAccount.getBalence();
		long fromAccountbalence = fromAccount.getBalence();

		AccountValidation.validateTransferAmmount(fromAccountbalence, ammount);
		AccountValidation.validateBalence(fromAccount);

		fromAccount.setBalence(fromAccountbalence - ammount);
		toAccount.setBalence(toAccountBalence + ammount);
		
		accountrepository.save(fromAccount);
		accountrepository.save(toAccount);

		Map<String, Account> accountMaps = new HashMap<>();
		accountMaps.put("To Account", toAccount);
		accountMaps.put("From Account", fromAccount);

		return new ResponseEntity<Map<String, Account>>("Transaction done", accountMaps, HttpStatus.OK);

	}

}
