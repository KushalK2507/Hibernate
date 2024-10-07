package org.kushal.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@NamedQuery(name = "Users.byID", query = "from Users where " + "userId = :id")
@NamedNativeQuery(
    name = "Users.byName",
    query = "select from users_details where username = :name",
    resultClass = Users.class)
@Table(name = "users_details")
public class Users {

  @Id
  @GeneratedValue
  @Column(name = "user_id")
  int userId;

  @Column(
      name =
          "username") // This is optional as the name of the column and data member are exactly the
  // same
  String username;

  @Column(name = "email")
  String email;

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
    return "Users [userId=" + userId + ", username=" + username + ", email=" + email + "]";
  }
}
