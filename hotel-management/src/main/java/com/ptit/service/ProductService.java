package com.ptit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.InProductDAO;
import com.ptit.dao.OutProductDAO;
import com.ptit.product.InProduct;

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

}
