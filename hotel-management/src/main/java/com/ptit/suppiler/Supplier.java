package com.ptit.suppiler;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "supplier")
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "supplier_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "supplier_name", columnDefinition = "VARCHAR(100)")
	private String name;
	
	@Column(name = "contact", columnDefinition = "VARCHAR(100)")
	private String contact;

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
