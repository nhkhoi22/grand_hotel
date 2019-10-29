package com.ptit.outcome;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ptit.product.Service;

import lombok.Data;

@Data
@Entity
@Table(name = "request_details")
public class RequestDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "detail_id", columnDefinition = "BIGINT")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "request_id", nullable = false)
	private SpendingRequest request;
	
	@ManyToOne
	@JoinColumn(name = "product_service_id", nullable = true)
	private Service service;
	
	@Column(name = "quantity", columnDefinition = "INT")
	private int quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SpendingRequest getRequest() {
		return request;
	}

	public void setRequest(SpendingRequest request) {
		this.request = request;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
