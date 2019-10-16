package com.ptit.outcome;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ptit.product.ProductType;
import com.ptit.staff.User;

import lombok.Data;

@Data
@Entity
@Table(name = "spending_request")
public class SpendingRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_id", columnDefinition = "BIGINT")
	private Long id;
	
	@Column(name = "product_name", columnDefinition = "VARCHAR(100)")
	private String productName;
	
	@ManyToOne
	@JoinColumn(name = "product_type_id", nullable = true)
	private ProductType productType;
	
	@ManyToOne
	@JoinColumn(name = "request_staff_id", nullable = true)
	private User user;
	
	@Column(name = "request_time", columnDefinition = "VARCHAR(50)")
	private String time;
	
	@Column(name = "content", columnDefinition = "LONGBLOB")
	private String content;
	
	@Column(name = "supplier", columnDefinition = "VARCHAR(100)")
	private String supplier;
	
	@Column(name = "quantity", columnDefinition = "INT")
	private Long quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
