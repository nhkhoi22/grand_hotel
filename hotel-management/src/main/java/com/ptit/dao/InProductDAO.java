package com.ptit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.product.InProduct;

public interface InProductDAO extends JpaRepository<InProduct, Long>{
	
	List<InProduct> findAll();
	
}
