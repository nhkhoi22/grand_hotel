package com.ptit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.staff.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	User findByStaffCode(String staffCode);
}
