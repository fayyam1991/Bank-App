package com.india.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.india.bank.dto.UserResponse;
import com.india.bank.repository.Accountrepository;

@Service
public class UserService {
	
	@Autowired
	private Accountrepository accountrepository;
	
	public List<UserResponse> getUserInfo(){
		return accountrepository.getUserResponse();
	}

}
