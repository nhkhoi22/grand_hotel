package com.ptit.staff;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ptit.customer.Bill;
import com.ptit.outcome.ConfirmedRequest;
import com.ptit.outcome.SpendingRequest;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "staff_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "staff_code", columnDefinition = "VARCHAR(10)")
	private String staffCode;
	
	@Column(name = "gender", columnDefinition = "VARCHAR(50)")
	private String gender;
	
	@Column(name = "full_name", columnDefinition = "VARCHAR(50)")
	private String name;
	
	@Column(name = "password", columnDefinition = "VARCHAR(255)")
	private String password;
	
	@Column(name = "active", columnDefinition = "INT")
    private int active;
	
	@Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", nullable = false)
    @JsonIgnore
    private Position position;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    @JsonIgnore
	private Role role;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user"
    )
    @JsonIgnore
    private List<Bill> bills;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user"
    )
    @JsonIgnore
    private List<SpendingRequest> requests;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user"
    )
    @JsonIgnore
    private List<ConfirmedRequest> responses;
	
	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public List<SpendingRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<SpendingRequest> requests) {
		this.requests = requests;
	}

	public List<ConfirmedRequest> getResponses() {
		return responses;
	}

	public void setResponses(List<ConfirmedRequest> responses) {
		this.responses = responses;
	}

	@Column(name = "days_in_work", columnDefinition = "INT")
	private int daysInWork;
	
	@Column(name = "contract_salary", columnDefinition = "BIGINT")
	private Long contractSalary;
	
	@Column(name = "last_time_login", columnDefinition = "VARCHAR(50)")
	private String lastlogin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getDaysInWork() {
		return daysInWork;
	}

	public void setDaysInWork(int daysInWork) {
		this.daysInWork = daysInWork;
	}

	public Long getContractSalary() {
		return contractSalary;
	}

	public void setContractSalary(Long contractSalary) {
		this.contractSalary = contractSalary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
