package com.ptit.staff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "staff_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "staff_code", columnDefinition = "VARCHAR(10)")
	@NotEmpty(message = "*Please provide staff code")
	private String staffCode;
	
	@Column(name = "full_name", columnDefinition = "VARCHAR(50)")
	@NotEmpty(message = "*Please provide staff name")
	private String name;
	
	@Column(name = "password", columnDefinition = "VARCHAR(255)")
	@NotEmpty(message = "*Please provide password")
	private String password;
	
	@Column(name = "active", columnDefinition = "INT")
    private int active;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", nullable = false)
    @JsonIgnore
    private Position position;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    @JsonIgnore
	private Role role;
	
	@Column(name = "days_in_work", columnDefinition = "INT")
	private int daysInWork;
	
	@Column(name = "contract_salary", columnDefinition = "BIGINT")
	private Long contractSalary;

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
	
}
