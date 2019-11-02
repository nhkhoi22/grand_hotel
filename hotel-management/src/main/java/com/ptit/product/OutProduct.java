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

import lombok.Data;

@Data
@Entity
@Table(name = "out_product")
public class OutProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "out_product_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "out_product_name", columnDefinition = "VARCHAR(50)")
	private String name;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "service"
    )
    private List<BillDetail> details;//1 dịch vụ có thể xuất hiện nhiều lần trong bảng chi tiết hóa đơn
	
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
	
	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
}
