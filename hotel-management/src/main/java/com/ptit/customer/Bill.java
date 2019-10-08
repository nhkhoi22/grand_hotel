package com.ptit.customer;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bill")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "bill_code", columnDefinition = "VARCHAR(50)")
	private String code;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bill_detail_connect", joinColumns = @JoinColumn(name = "bill_id"), inverseJoinColumns = @JoinColumn(name = "detail_id"))
    private Set<BillDetail> details;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
