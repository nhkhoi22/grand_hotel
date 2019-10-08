package com.ptit.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "service")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "service_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "service_name", columnDefinition = "VARCHAR(50)")
	private String name;
	
	@Column(name = "price", columnDefinition = "DOUBLE")
	private Double price;
}
