package org.kushal.hibernate.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("4Wheeler")
public class FourWheeler extends Vehicle {

  private String steeringWheel;

  public String getSteeringWheel() {
    return steeringWheel;
  }

  public void setSteeringWheel(String steeringWheel) {
    this.steeringWheel = steeringWheel;
  }
}
