package com.ptit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.InProductDAO;
import com.ptit.dao.OutProductDAO;
import com.ptit.product.InProduct;
import com.ptit.product.OutProduct;

@Service("productService")
public class ProductService {
	
	@Autowired
	private OutProductDAO productDAO;
	
	@Autowired
	private InProductDAO inProductDao;
	
	public List<com.ptit.product.OutProduct> findAllService() {
		return productDAO.findAll();
	}
	
	public List<InProduct> findAllInProduct() {
		return inProductDao.findAll();
	}
	
	public OutProduct findOutProductById(Integer id) {
		if(productDAO.findById(id) != null) {
			return productDAO.findOutProductById(id);
		}
		return null;
	}
	
	public OutProduct findByName(String name) {
		return productDAO.findOutProductByName(name);
	}

}
