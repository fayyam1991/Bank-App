package com.india.bank.dto;

import org.springframework.http.HttpStatus;

public class ResponseEntity<T> {
	private String message;
	private T responseObj;
	private HttpStatus status;

	public ResponseEntity() {
		super();
	}

	public ResponseEntity(String message, T responseObj, HttpStatus status) {
		super();
		this.message = message;
		this.responseObj = responseObj;
		this.status = status;
	}




	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponseObj() {
		return responseObj;
	}

	public void setResponseObj(T responseObj) {
		this.responseObj = responseObj;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
