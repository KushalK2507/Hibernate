package org.kushal.hibernate.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  int userId;

  @Column(
      name =
          "username") // This is optional as the name of the column and data member are exactly the
  // same
  String username;

  @Column(name = "email")
  String email;

  @Embedded private Address address;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "street", column = @Column(name = "Company_Street")),
    @AttributeOverride(name = "city", column = @Column(name = "Company_City")),
    @AttributeOverride(name = "pincode", column = @Column(name = "Company_pincode")),
    @AttributeOverride(name = "state", column = @Column(name = "Company_state"))
  })
  private Address companyAddress;

  @ElementCollection(fetch = FetchType.EAGER) // Name of the table will be users_listAddress
  @JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"))
  private Set<Address> listAddress = new HashSet<>();

  public Users() {}

  public Users(int userId, String username, String email) {
    this.userId = userId;
    this.username = username;
    this.email = email;
  }

  public Users(String username, String email) {
    this.username = username;
    this.email = email;
  }

  public Address getCompanyAddress() {
    return companyAddress;
  }

  public void setCompanyAddress(Address companyAddress) {
    this.companyAddress = companyAddress;
  }

  public Set<Address> getListAddress() {
    return listAddress;
  }

  public void setListAddress(Set<Address> listAddress) {
    this.listAddress = listAddress;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Users [userId="
        + userId
        + ", username="
        + username
        + ", email="
        + email
        + ", address="
        + address
        + ", companyAddress="
        + companyAddress
        + "]";
  }
}
