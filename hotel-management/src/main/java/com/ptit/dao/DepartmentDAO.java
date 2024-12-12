package com.ptit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.staff.Department;
import com.ptit.staff.Position;

public interface DepartmentDAO extends JpaRepository<Department, Long>{
	List<Position> findPositionsByName(String name);
	
	Department findByName(String name);
	
	List<Department> findAll();
	
	Department findDepartmentById(Long id);
}
