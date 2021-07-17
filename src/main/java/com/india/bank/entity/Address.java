package com.india.bank.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS_INFO")
public class Address extends AbstractEntity {
	private String city;
	private String state;
	private String code;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
