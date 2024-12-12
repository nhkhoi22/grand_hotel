package com.ptit.outcome;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ptit.product.InProduct;

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
	@JoinColumn(name = "in_product_id", nullable = true)
	private InProduct inProduct;
	
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public InProduct getInProduct() {
		return inProduct;
	}

	public void setInProduct(InProduct inProduct) {
		this.inProduct = inProduct;
	}
	
}
