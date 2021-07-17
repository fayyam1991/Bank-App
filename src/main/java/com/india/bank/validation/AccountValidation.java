package com.india.bank.validation;

import com.india.bank.entity.Account;
import com.india.bank.exception.InSufficientFundException;

public class AccountValidation {

	public static boolean validateBalence(Account account) {

		if (account.getBalence() == 0) {
			throw new InSufficientFundException("Insuffient Fund");
		}
		return true;
	}

	public static boolean validateTransferAmmount(long balenceAmmount, long deductableAmmount) {

		if (balenceAmmount < deductableAmmount) {
			throw new InSufficientFundException("Insufficent Fund");
		}
		return true;
	}

}
