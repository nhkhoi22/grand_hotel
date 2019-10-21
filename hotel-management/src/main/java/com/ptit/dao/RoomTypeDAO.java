package com.ptit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.customer.RoomType;

public interface RoomTypeDAO extends JpaRepository<RoomType, Long> {

}
