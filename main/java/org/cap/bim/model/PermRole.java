package org.cap.bim.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "permrole")
public class PermRole
{
	@Id
	@Column(name = "role_number")
	private int roleNumber;
	
	@Column(name = "perm_role")
	private String permRole;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "permRole")
	@JsonManagedReference
	List<User> users=new ArrayList<>();



	public PermRole() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PermRole(int roleNumber, String permRole) {
		super();
		this.roleNumber = roleNumber;
		this.permRole = permRole;
	}



	public int getRoleNumber() {
		return roleNumber;
	}



	public void setRoleNumber(int roleNumber) {
		this.roleNumber = roleNumber;
	}



	public String getPermRole() {
		return permRole;
	}



	public void setPermRole(String permRole) {
		this.permRole = permRole;
	}

	
	
	
}
