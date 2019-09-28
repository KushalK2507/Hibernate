package org.kushal.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	int userId;

	@Column(name = "username") // This is optional as the name of the column and data member are exactly the
								// same
	String username;

	@Column(name = "email")
	String email;

	@Embedded
	private Address address;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "Company_Street")),
			@AttributeOverride(name = "city", column = @Column(name = "Company_City")),
			@AttributeOverride(name = "pincode", column = @Column(name = "Company_pincode")),
			@AttributeOverride(name = "state", column = @Column(name = "Company_state")) })
	private Address companyAddress;

	@ElementCollection(fetch=FetchType.EAGER) // Name of the table will be users_listAddress
	@JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"))
	private Set<Address> listAddress = new HashSet<>();

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

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", email=" + email + ", address=" + address
				+ ", companyAddress=" + companyAddress + "]";
	}

}
