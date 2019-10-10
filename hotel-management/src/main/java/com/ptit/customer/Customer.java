package com.ptit.customer;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<RoomReservation> rooms;

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
}
