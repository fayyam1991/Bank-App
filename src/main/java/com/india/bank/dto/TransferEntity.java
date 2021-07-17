package com.india.bank.dto;

public class TransferEntity {
	private String fromAccount;
	private String toAccount;
	private long ammount;

	public TransferEntity() {
		super();
	}

	public TransferEntity(String fromAccount, String toAccount, long ammount) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.ammount = ammount;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public long getAmmount() {
		return ammount;
	}

	public void setAmmount(long ammount) {
		this.ammount = ammount;
	}

}
