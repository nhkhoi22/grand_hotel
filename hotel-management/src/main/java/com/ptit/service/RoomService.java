package com.ptit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.customer.Customer;
import com.ptit.customer.RoomType;
import com.ptit.dao.CustomerDAO;
import com.ptit.dao.RoomTypeDAO;

@Service("roomService")
public class RoomService {
	
	@Autowired
	private RoomTypeDAO roomTypeDao;
	
	@Autowired
	private CustomerDAO customerDao;
	
	public List<RoomType> findAllRoomType() {
		return roomTypeDao.findAll();
	}
	
	public List<Customer> findAllCustomer() {
		return customerDao.findAll();
	}
}
