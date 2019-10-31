package com.ptit.suppiler;

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
@Table(name = "contract_supply_detail")
public class ContractSupplyDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contract_supply_detail_id", columnDefinition = "BIGINT")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "contract_id", columnDefinition = "INT")
	private Contract contract;
	
	@ManyToOne
	@JoinColumn(name = "product_service_id", columnDefinition = "INT")
	private Service service;
	
	@Column(name = "outcome_price", columnDefinition = "DOUBLE")
	private Double outcomePrice;
	
	@Column(name = "currently_active", columnDefinition = "INT")
	private boolean currentlyActive;

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

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Double getOutcomePrice() {
		return outcomePrice;
	}

	public void setOutcomePrice(Double outcomePrice) {
		this.outcomePrice = outcomePrice;
	}

	public boolean isCurrentActive() {
		return currentlyActive;
	}

	public void setCurrentActive(boolean currentlyActive) {
		this.currentlyActive = currentlyActive;
	}
}
