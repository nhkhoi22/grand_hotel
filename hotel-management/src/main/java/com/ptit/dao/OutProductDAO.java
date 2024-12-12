package com.ptit.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ptit.product.OutProduct;

public interface OutProductDAO extends CrudRepository<OutProduct, Integer>{
	
	List<OutProduct> findAll();
	
	OutProduct findOutProductById(Integer Id);
	
	OutProduct findOutProductByName(String name);
}
