package com.ptit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.product.OutProduct;

public interface ProductDAO extends JpaRepository<OutProduct, Long>{
	
	List<OutProduct> findAll();
	
}
