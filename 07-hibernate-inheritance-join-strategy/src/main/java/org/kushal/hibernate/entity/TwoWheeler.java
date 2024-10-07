package org.kushal.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "2_Wheeler")
public class TwoWheeler extends Vehicle {

  private String steeringHandle;

  public String getSteeringHandle() {
    return steeringHandle;
  }

  public void setSteeringHandle(String steeringHandle) {
    this.steeringHandle = steeringHandle;
  }
}
