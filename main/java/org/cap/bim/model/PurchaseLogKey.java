package org.cap.bim.model;

import java.io.Serializable;
import java.util.Objects;

public class PurchaseLogKey implements Serializable{
	
	private int userId;
	private int inventoryId;
	
	//No-arg constructor
	public PurchaseLogKey() {
		super();
	}

	//Full-arg constructor
	public PurchaseLogKey(int userId, int inventoryId) {
		super();
		this.userId = userId;
		this.inventoryId = inventoryId;
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

	//hashCode method
	@Override
	public int hashCode() {
		return Objects.hash(inventoryId, userId);
	}

	//Equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseLogKey other = (PurchaseLogKey) obj;
		return inventoryId == other.inventoryId && userId == other.userId;
	}

	//toString method
	@Override
	public String toString() {
		return "PurchaseLogKey [userId=" + userId + ", inventoryId=" + inventoryId + "]";
	}
	
	

}
