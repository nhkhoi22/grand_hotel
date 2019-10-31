package com.ptit.suppiler;

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

import lombok.Data;

@Data
@Entity
@Table(name = "contract")
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contract_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "contract_code", columnDefinition = "VARCHAR(50)")
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id", columnDefinition = "INT")
	private Supplier supplier;
	
	@Column(name = "start_date", columnDefinition = "VARCHAR(20)")
	private String startDate;
	
	@Column(name = "end_date", columnDefinition = "VARCHAR(20)")
	private String endDate;
	
	@OneToMany(
			cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "contract")
	private List<ContractSupplyDetail> contractDetails;
}
