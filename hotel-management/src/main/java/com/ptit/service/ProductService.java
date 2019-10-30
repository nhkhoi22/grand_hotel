package com.ptit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.ProductDAO;

@Service("requestService")
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	public List<com.ptit.product.Service> findAllService() {
		return productDAO.findAll();
	}

}