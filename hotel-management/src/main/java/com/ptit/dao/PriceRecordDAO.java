package com.ptit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.product.PriceHistory;

public interface PriceRecordDAO  extends JpaRepository<PriceHistory, Long>{
	
	List<PriceHistory> findAll();
	
}
