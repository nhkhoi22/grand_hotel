package com.ptit.customer;

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

import com.ptit.product.ProductType;

import lombok.Data;

@Data
@Entity
@Table(name = "service")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "service_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "service_name", columnDefinition = "VARCHAR(50)")
	private String name;
	
	@Column(name = "price", columnDefinition = "DOUBLE")
	private Double price;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "service"
    )
    private List<BillDetail> details;//1 dịch vụ có thể xuất hiện nhiều lần trong bảng chi tiết hóa đơn
	
	@ManyToOne
	@JoinColumn(name = "product_type_id", nullable = true)
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<BillDetail> getDetails() {
		return details;
	}

	public void setDetails(List<BillDetail> details) {
		this.details = details;
	}
	
}