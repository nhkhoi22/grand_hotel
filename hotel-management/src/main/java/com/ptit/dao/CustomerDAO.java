package com.ptit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.customer.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Long> {
	
	List<Customer> findAll();
	
}
