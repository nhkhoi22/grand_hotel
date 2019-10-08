package com.ptit.customer;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "full_name", columnDefinition = "VARCHAR(50)")
	private String name;
	
	@Column(name = "phone_number", columnDefinition = "VARCHAR(50)")
	private String phoneNumber;
	
	@Column(name = "address", columnDefinition = "VARCHAR(50)")
	private String address;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = true)
    @JsonIgnore
    private Room room;
	
	@Column(name = "check_in", columnDefinition = "VARCHAR(50)")
	private String checkInDate;
	
	@Column(name = "check_out", columnDefinition = "VARCHAR(50)")
	private String checkOutDate;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_bill", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "bill_id"))
	private Set<Bill> bills;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
}
