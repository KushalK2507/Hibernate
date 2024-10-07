package org.kushal.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

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

  @OneToMany
  @JoinTable(
      name = "person_vehicle",
      joinColumns = @JoinColumn(name = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
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
