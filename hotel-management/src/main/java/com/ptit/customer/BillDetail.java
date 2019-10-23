package com.ptit.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ptit.product.Service;

import lombok.Data;

@Data
@Entity
@Table(name = "bill_detail")
public class BillDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "detail_id", columnDefinition = "INT")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    @JsonIgnore
	private Service service; //1 service có thể xuất hiện trong nhiều bill_detail
    
	@Column(name = "quantity", columnDefinition = "BIGINT")
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bill_id", nullable = false)
	private Bill bill; //1 bill detail chỉ thuộc 1 hóa đơn

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
