package org.kushal.hibernate.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("2Wheeler")
public class TwoWheeler extends Vehicle {

  private String steeringHandle;

  public String getSteeringHandle() {
    return steeringHandle;
  }

  public void setSteeringHandle(String steeringHandle) {
    this.steeringHandle = steeringHandle;
  }
}
