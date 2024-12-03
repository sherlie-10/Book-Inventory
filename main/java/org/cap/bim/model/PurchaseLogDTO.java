package org.cap.bim.model;

public class PurchaseLogDTO {
	
	private int userId;
	private int inventoryId;
	
	
	
	
	public PurchaseLogDTO() {
		super();
	}
	public PurchaseLogDTO(int userId, int inventoryId) {
		super();
		this.userId = userId;
		this.inventoryId = inventoryId;
	}
	
	public PurchaseLogDTO(int inventoryId) {
		super();
		this.inventoryId = inventoryId;
	}
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
	
	

}
