package org.kushal.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "Person_Vehicles")
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int vehicleId;

  @Column(name = "Vehcile_Name")
  private String vehicleName;

  @ManyToOne
  @JoinColumn(name = "person_id")
  @NotFound(action = NotFoundAction.IGNORE)
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
