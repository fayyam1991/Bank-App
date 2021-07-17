package com.india.bank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.india.bank.dto.ResponseEntity;
import com.india.bank.dto.TransferEntity;
import com.india.bank.entity.Account;
import com.india.bank.service.balenceTransferService;

@RestController
@RequestMapping("/bank/transfer")
@EnableTransactionManagement
public class BalenceTransferController {
	
	@Autowired
	private balenceTransferService balenceTransferService;
	
	@PutMapping
	public ResponseEntity<Map<String, Account>> fundTransfer(@RequestBody TransferEntity transferEntity){
		return balenceTransferService.transferBalence(transferEntity);
	}

}
