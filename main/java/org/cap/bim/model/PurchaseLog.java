package org.cap.bim.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchaselog")
@IdClass(PurchaseLogKey.class)
public class PurchaseLog 

{
	@Id
	@Column(name = "UserID")
	private int userId;
	
	@Id
	@Column(name = "InventoryID")
	private int inventoryId;
	
	
	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "UserID",referencedColumnName = "UserID" ,insertable = false,updatable = false)
	private User user;
	
	//No-arg constructor
	public PurchaseLog() {
		super();
	}

	//Full-arg constructor
	public PurchaseLog(int userId, int inventoryId, User user) {
		super();
		this.userId = userId;
		this.inventoryId = inventoryId;
		this.user = user;
	}

	public PurchaseLog(int i, int j) {
	}

	//Getters & Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
