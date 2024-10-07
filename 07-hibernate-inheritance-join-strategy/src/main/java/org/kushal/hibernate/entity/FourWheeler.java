package org.kushal.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "4_Wheeler")
public class FourWheeler extends Vehicle {

  private String steeringWheel;

  public String getSteeringWheel() {
    return steeringWheel;
  }

  public void setSteeringWheel(String steeringWheel) {
    this.steeringWheel = steeringWheel;
  }
}
