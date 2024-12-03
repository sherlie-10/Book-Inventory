package org.cap.bim.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User 
{
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "UserID")
	private int userId; 
	
	@Column(name = "last_name",length = 30,nullable = false)
	private String lastName;
	
	@Column(name = "first_name",length = 20,nullable = false)
	private String firstName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "user_name",length = 30,nullable = false)
	private String userName;
	
	@Column(name = "Password",length = 30,nullable = false)
	private String password;
	
	
	@Column(name="role_number")
	private int permrole;
	
	@ManyToOne
	@JoinColumn(name = "role_number",referencedColumnName = "role_number",insertable = false,updatable = false)
	@JsonBackReference
	private PermRole permRole;	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	List<PurchaseLog> PurchaseLog=new ArrayList<>();
	
	public User() {
		super();
	}


	public User(int userId, String lastName, String firstName, String phoneNumber, String userName, String password,
			int permrole, PermRole permRole2) {
		super();
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.permrole = permrole;
		permRole = permRole2;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getPermrole() {
		return permrole;
	}


	public void setPermrole(int permrole) {
		this.permrole = permrole;
	}


	public PermRole getPermRole() {
		return permRole;
	}


	public void setPermRole(PermRole permRole) {
		this.permRole = permRole;
	}
	
	
	
	
}
