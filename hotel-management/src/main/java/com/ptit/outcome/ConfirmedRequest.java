package com.ptit.outcome;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ptit.staff.User;

import lombok.Data;

@Data
@Entity
@Table(name = "confirmed_request")
public class ConfirmedRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "confirm_request_id", columnDefinition = "BIGINT")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "request_id", nullable = true)
	private SpendingRequest request;
	
	@ManyToOne
	@JoinColumn(name = "confirm_staff_id", nullable = true)
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "confirm_time", nullable = false)
	private Date confirmTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SpendingRequest getRequest() {
		return request;
	}

	public void setRequest(SpendingRequest request) {
		this.request = request;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
}
