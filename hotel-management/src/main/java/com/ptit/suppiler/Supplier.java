package com.ptit.suppiler;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ptit.product.Service;

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
	
	@Column(name = "begin_contract_date", columnDefinition = "VARCHAR(20)")
	private String beginContractDate;
	
	@Column(name = "end_contract_date", columnDefinition = "VARCHAR(20)")
	private String endContractDate;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "supplier"
    )
	private List<Service> services;
	
}
