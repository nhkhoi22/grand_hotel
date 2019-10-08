package com.ptit.staff;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "department")
public class Department implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id", columnDefinition = "INT")
	private Long id;
	
	@Column(name = "department_name", columnDefinition = "VARCHAR(100)")
	@NotEmpty(message = "*Please provide department name")
	private String name;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "department"
    )
    @JsonIgnore
    private List<Position> positions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public Department() {
		super();
		this.positions = new ArrayList<Position>();
		this.name = "";
	}
	
}
