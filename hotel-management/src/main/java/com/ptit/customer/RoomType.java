package com.ptit.customer;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "room_type")
public class RoomType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "room_type_id", columnDefinition = "INT")
	private int id;
	
	@Column(name = "room_type_name", columnDefinition = "VARCHAR(50)")
	private String name;
	
	@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "roomType"
    )
    @JsonIgnore
    private List<Room> rooms;
}
