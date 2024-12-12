package com.ptit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.outcome.SpendingRequest;

public interface RequestDAO extends JpaRepository<SpendingRequest, Long>{
	
	List<SpendingRequest> findAll();
	
}
