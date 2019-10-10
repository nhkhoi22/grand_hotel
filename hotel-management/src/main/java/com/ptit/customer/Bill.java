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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "bill")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "payment_time", columnDefinition = "VARCHAR(50)")
	private String time;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id", nullable = false)
	private Room room;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bill"
    )
    @JsonIgnore
    private List<BillDetail> billDetails;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
