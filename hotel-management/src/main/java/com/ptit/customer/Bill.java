package com.ptit.customer;


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ptit.staff.User;

import lombok.Data;

@Data
@Entity
@Table(name = "bill")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_id", columnDefinition = "INT")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_time", nullable = true)
	private Date paymentTime;
	
	@ManyToOne
	@JoinColumn(name = "staff_id", nullable = true)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "reservation_id", nullable = true)
	private RoomReservation reservation;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", columnDefinition = "INT")
	private Customer customer;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bill"
    )
    @JsonIgnore
    private List<BillDetail> billDetails;//1 hóa đơn có nhiều chi tiết hóa đơn
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public RoomReservation getReservation() {
		return reservation;
	}

	public void setReservation(RoomReservation reservation) {
		this.reservation = reservation;
	}
	
}
