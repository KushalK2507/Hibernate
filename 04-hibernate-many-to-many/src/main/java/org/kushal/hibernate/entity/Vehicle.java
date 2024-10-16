package org.kushal.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Person_Vehicles")
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int vehicleId;

  @Column(name = "Vehcile_Name")
  private String vehicleName;

  @ManyToMany(
      mappedBy =
          "vehicle") // In mappedby we give the name of object that is created in Person class for
  // creating the collection of Vehicle in Person.
  private Collection<Persons> person = new ArrayList<>();

  public Collection<Persons> getPerson() {
    return person;
  }

  public void setPerson(Collection<Persons> person) {
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
