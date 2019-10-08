package com.ptit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.staff.Role;

public interface RoleDAO extends JpaRepository<Role, Integer>{
	Role findByName(String name);
}
