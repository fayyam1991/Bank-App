package com.india.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.india.bank.entity.Address;

public interface AddressRepository extends JpaRepository<Address, String>{
	
	

}
