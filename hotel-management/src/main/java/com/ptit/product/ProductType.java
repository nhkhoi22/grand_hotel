package com.ptit.product;

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

import lombok.Data;

@Data
@Entity
@Table(name = "service_product_type")
public class ProductType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "service_product_type_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "service_product_type_name", columnDefinition = "VARCHAR(100)")
	private String name;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "productType"
    )
	private List<Service> services;
	
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

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
}
