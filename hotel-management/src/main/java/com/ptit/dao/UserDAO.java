package com.ptit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.staff.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	User findByStaffCode(String staffCode);
	
	User findByStaffCode(Optional<String> staffCode);
	
	List<User> findAll();

	
}
