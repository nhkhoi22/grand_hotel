package com.ptit.suppiler;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "contract")
public class Contract {
	
	@Id
	@Column(name = "contract_code", columnDefinition = "VARCHAR(50)")
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id", columnDefinition = "INT")
	private Supplier supplier;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = false)
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", nullable = false)
	private Date endDate;
	
	@OneToMany(
			cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "contract")
	private List<ContractSupplyDetail> contractDetails;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<ContractSupplyDetail> getContractDetails() {
		return contractDetails;
	}

	public void setContractDetails(List<ContractSupplyDetail> contractDetails) {
		this.contractDetails = contractDetails;
	}
	
}
