package com.ptit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.customer.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Long> {
}
