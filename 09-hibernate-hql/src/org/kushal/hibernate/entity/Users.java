package org.kushal.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="users")
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	int userId;

	@Column(name = "username") // This is optional as the name of the column and data member are exactly the same
	String username;

	@Column(name = "email")
	String email;

	
	public Users() {
		
	}

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

	

	
}
