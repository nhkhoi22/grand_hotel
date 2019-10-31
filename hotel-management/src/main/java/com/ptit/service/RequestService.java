package com.ptit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.RequestDAO;
import com.ptit.outcome.SpendingRequest;

@Service("requestService")
public class RequestService {
	
	@Autowired
	private RequestDAO requestDao;
	
	public void saveRequest(SpendingRequest request) {
		requestDao.save(request);
	}
}
