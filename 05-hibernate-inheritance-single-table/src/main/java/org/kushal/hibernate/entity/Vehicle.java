package org.kushal.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Vehicle_type", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "vehicle_id")
  private int vehicleId;

  @Column(name = "vehicle_name")
  private String VehicleName;

  public int getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(int vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getVehicleName() {
    return VehicleName;
  }

  public void setVehicleName(String vehicleName) {
    VehicleName = vehicleName;
  }
}
