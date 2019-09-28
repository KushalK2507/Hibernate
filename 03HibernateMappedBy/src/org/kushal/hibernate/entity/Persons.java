package org.kushal.hibernate.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Person_details")
public class Persons {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Person_id")
	private int id;
	private String name;
	@OneToOne
	@JoinColumn(name = "House_number")
	private House house;

	@OneToMany(mappedBy = "person") // Here the name will be the name of the object for which it needs to be mapped
									// i.e. person which is present in Vehicle class
	private Collection<Vehicle> vehicle = new ArrayList<>();

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

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

}