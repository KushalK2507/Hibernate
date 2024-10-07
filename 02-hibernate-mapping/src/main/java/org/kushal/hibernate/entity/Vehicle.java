package org.kushal.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person_Vehicles")
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int vehicleId;

  @Column(name = "Vehcile_Name")
  private String vehicleName;

  @ManyToOne
  @JoinTable(name = "Vehicles_person")
  private Persons person;

  public Persons getPerson() {
    return person;
  }

  public void setPerson(Persons person) {
    this.person = person;
  }

  public int getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(int vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getVehicleName() {
    return vehicleName;
  }

  public void setVehicleName(String vehicleName) {
    this.vehicleName = vehicleName;
  }
}
