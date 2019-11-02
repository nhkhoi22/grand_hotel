package com.ptit.suppiler;

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
@Table(name = "contract_supply_detail")
public class ContractSupplyDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contract_supply_detail_id", columnDefinition = "BIGINT")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "contract_code", columnDefinition = "VARCHAR(50)")
	private Contract contract;
	
	@ManyToOne
	@JoinColumn(name = "in_product_id", columnDefinition = "INT")
	private InProduct inProduct;
	
	@Column(name = "outcome_price", columnDefinition = "DOUBLE")
	private Double outcomePrice;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Double getOutcomePrice() {
		return outcomePrice;
	}

	public void setOutcomePrice(Double outcomePrice) {
		this.outcomePrice = outcomePrice;
	}

	public InProduct getInProduct() {
		return inProduct;
	}

	public void setInProduct(InProduct inProduct) {
		this.inProduct = inProduct;
	}

}
