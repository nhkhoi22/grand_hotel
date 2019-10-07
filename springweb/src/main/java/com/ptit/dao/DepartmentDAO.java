package com.ptit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.model.Department;
import com.ptit.model.Position;

public interface DepartmentDAO extends JpaRepository<Department, Long>{
	List<Position> findPositionsByName(String name);
	
	Department findByName(String name);
	
	List<Department> findAll();
}
