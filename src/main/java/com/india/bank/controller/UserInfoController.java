package com.india.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.india.bank.dto.ResponseEntity;
import com.india.bank.dto.UserResponse;
import com.india.bank.service.UserService;

@RestController
@RequestMapping("/bank/users")
public class UserInfoController {
	@Autowired
	private UserService userService;

	@GetMapping("/info")
	public ResponseEntity<List<UserResponse>> getUserInfo() {
		List<UserResponse> userInfo = userService.getUserInfo();
		return new ResponseEntity<>("SuccessFull", userInfo, HttpStatus.OK);
	}
}
