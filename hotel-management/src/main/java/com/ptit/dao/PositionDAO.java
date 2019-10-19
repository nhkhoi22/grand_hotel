package com.ptit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.staff.Department;
import com.ptit.staff.Position;

public interface PositionDAO extends JpaRepository<Position, Long> {
	Position findByName(String name);
	
	Position findPositionById(Long id);
	
	List<Position> findPositionByDepartment(Department department);
}
