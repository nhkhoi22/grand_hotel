package com.ptit.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ptit.outcome.RequestDetail;
import com.ptit.suppiler.ContractSupplyDetail;

import lombok.Data;

@Data
@Entity
@Table(name = "in_product")
public class InProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "in_product_id", columnDefinition = "INT")
	private Long id;
	
	@Column(name = "product_name", columnDefinition = "VARCHAR(100)")
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_type_id", columnDefinition = "INT")
	private ProductType productType;
	
	@OneToMany(
			cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "inProduct")
	private List<ContractSupplyDetail> details;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "service"
    )
    private List<RequestDetail> requestDetails;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public List<ContractSupplyDetail> getDetails() {
		return details;
	}

	public void setDetails(List<ContractSupplyDetail> details) {
		this.details = details;
	}

}
