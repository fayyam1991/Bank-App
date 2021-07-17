package com.india.bank.exception;

public class InSufficientFundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InSufficientFundException(String message) {
		super(message);
	}

}
