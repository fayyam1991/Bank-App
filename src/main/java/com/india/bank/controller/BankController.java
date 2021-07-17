package com.india.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.india.bank.dto.ResponseEntity;
import com.india.bank.entity.Account;
import com.india.bank.service.BankService;

import io.swagger.annotations.ApiOperation;

/**
 * The class BankController
 * 
 * @author Fayyam
 *
 */
@RestController
@RequestMapping("/bank/account")
public class BankController {

	@Autowired
	private BankService bankService;

	@GetMapping("/get")
	@ApiOperation(value = "Get account detail by accountNo", notes = "This APIs to fetch user account by account number", response = ResponseEntity.class)
	public ResponseEntity<List<Account>> getAccounts(@RequestHeader String accountNo) {
		return bankService.getAccounts(accountNo);
	}

	@PostMapping("/add")
	@ApiOperation(value = "Add account", notes = "This APIs is to add Account ", response = ResponseEntity.class)
	public ResponseEntity<?> addAccount(@RequestBody Account account) {
		bankService.addAccount(account);
		EntityModel<Account> resource = getResource(account);
		return new ResponseEntity<>("Account added successfully", resource, HttpStatus.OK);
	}

	@DeleteMapping("/remove")
	@ApiOperation(value = "Remove account", notes = "this APIs is to delete account", response = ResponseEntity.class)
	public ResponseEntity<Account> removeAccount(@RequestHeader String accountNo) {
		return bankService.deleteAccount(accountNo);
	}

	@PutMapping("/deposit")
	@ApiOperation(value = "Deposit ammount", notes = "This APIs is for deposit ammount", response = ResponseEntity.class)
	public ResponseEntity<Account> depositAmmount(@RequestHeader String accountNo, @RequestHeader long balence) {
		return bankService.update(accountNo, balence);
	}

	private EntityModel<Account> getResource(Account account) {
		EntityModel<Account> resource = EntityModel.of(account);
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).depositAmmount("", 0))
				.withRel("deposit"));
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAccounts("12346"))
				.withRel("Self"));
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).removeAccount(""))
				.withRel("remove"));

		return resource;
	}

}
