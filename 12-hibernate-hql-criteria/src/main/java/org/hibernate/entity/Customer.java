package org.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@NamedQuery(name = "allCustmers", query = "from Customer")
@NamedQuery(
    name = "customerByNetworkProvider",
    query = "from Customer where networkProvider= :networkProvider")
@NamedNativeQuery(
    name = "customerNameByNetworkProvider",
    query = "select * from customers where network_Provider= :networkProvider",
    resultClass = Customer.class)
@NamedNativeQuery(
    name = "customerByTelephoneNumber",
    query = "select customer_name from customers where telephone_Number like :telephoneNumber")
@Table(name = "customers")
public class Customer {

  @Column(name = "network_Provider")
  public String networkProvider;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "customer_id")
  private int customerId;

  @Column(name = "customer_name")
  private String name;

  @Column(name = "telephone_Number")
  private String telephoneNumber;

  @Column(name = "pin_Code")
  private String pinCode;

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTelephoneNumber() {
    return telephoneNumber;
  }

  public void setTelephoneNumber(String telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
  }

  public String getNetworkProvider() {
    return networkProvider;
  }

  public void setNetworkProvider(String networkProvider) {
    this.networkProvider = networkProvider;
  }

  public String getPinCode() {
    return pinCode;
  }

  public void setPinCode(String pinCode) {
    this.pinCode = pinCode;
  }

  @Override
  public String toString() {
    return "Customer [customerId="
        + customerId
        + ", name="
        + name
        + ", telephoneNumber="
        + telephoneNumber
        + ", networkProvider="
        + networkProvider
        + ", pinCode="
        + pinCode
        + "]";
  }
}
