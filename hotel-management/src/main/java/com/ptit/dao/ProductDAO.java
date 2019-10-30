package com.ptit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.product.Service;

public interface ProductDAO extends JpaRepository<Service, Long>{
	
	List<Service> findAll();
	
}
