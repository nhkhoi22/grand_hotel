package com.ptit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.customer.Room;

public interface RoomDAO extends JpaRepository<Room, Long> {

}
