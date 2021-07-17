package com.india.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.india.bank.dto.UserResponse;
import com.india.bank.entity.Account;

public interface Accountrepository extends JpaRepository<Account, String> {
	
	@Query("from Account where accountNo=?1")
	public Account findByAccountNumber(String accountNo);
	
	@Query("select new com.india.bank.dto.UserResponse(acc.name,adr.city) from Account acc JOIN acc.addresses adr")
	public List<UserResponse> getUserResponse();
}
