package com.ptit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.staff.Position;

public interface PositionDAO extends JpaRepository<Position, Long> {
	Position findByName(String name);
}
