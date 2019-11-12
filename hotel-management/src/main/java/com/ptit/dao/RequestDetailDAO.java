package com.ptit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.outcome.RequestDetail;

public interface RequestDetailDAO extends JpaRepository<RequestDetail, Long>{
	
	List<RequestDetail> findAll();
	
}

