package com.ptit.outcome;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ptit.product.Service;
import com.ptit.staff.User;

import lombok.Data;

@Data
@Entity
@Table(name = "product_request")
public class SpendingRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_id", columnDefinition = "BIGINT")
	private Long id;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "request_details", joinColumns = @JoinColumn(name = "request_id"), inverseJoinColumns = @JoinColumn(name = "product_service_id"))
	private List<Service> Services;
	
	@ManyToOne
	@JoinColumn(name = "request_staff_id", nullable = true)
	private User user;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "request"
    )
    private List<RequestDetail> requestDetails;
	
	@Column(name = "request_time", columnDefinition = "VARCHAR(50)")
	private String time;
	
	@Column(name = "content", columnDefinition = "LONGBLOB")
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Service> getServices() {
		return Services;
	}

	public void setServices(List<Service> services) {
		Services = services;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<RequestDetail> getRequestDetails() {
		return requestDetails;
	}

	public void setRequestDetails(List<RequestDetail> requestDetails) {
		this.requestDetails = requestDetails;
	}
	
}
