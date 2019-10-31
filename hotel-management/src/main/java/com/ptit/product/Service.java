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

import com.ptit.customer.BillDetail;
import com.ptit.outcome.RequestDetail;
import com.ptit.suppiler.ContractSupplyDetail;

import lombok.Data;

@Data
@Entity
@Table(name = "product_service")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_service_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "product_service_name", columnDefinition = "VARCHAR(50)")
	private String name;
	
	@Column(name = "income_price", columnDefinition = "DOUBLE")
	private Double incomePrice;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "service"
    )
    private List<BillDetail> details;//1 dịch vụ có thể xuất hiện nhiều lần trong bảng chi tiết hóa đơn
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "service"
    )
	private List<ContractSupplyDetail> contractDetails;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "service"
    )
    private List<RequestDetail> requestDetails;
	
	@ManyToOne
	@JoinColumn(name = "product_service_type_id", nullable = true)
	private ProductType productType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BillDetail> getDetails() {
		return details;
	}

	public void setDetails(List<BillDetail> details) {
		this.details = details;
	}

	public List<RequestDetail> getRequestDetails() {
		return requestDetails;
	}

	public void setRequestDetails(List<RequestDetail> requestDetails) {
		this.requestDetails = requestDetails;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Double getIncomePrice() {
		return incomePrice;
	}

	public void setIncomePrice(Double incomePrice) {
		this.incomePrice = incomePrice;
	}

	public List<ContractSupplyDetail> getContractDetails() {
		return contractDetails;
	}

	public void setContractDetails(List<ContractSupplyDetail> contractDetails) {
		this.contractDetails = contractDetails;
	}
	
}
