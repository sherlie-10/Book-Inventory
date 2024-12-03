package org.cap.bim.model;

public class InventoryDto 
{
	
	private int inventoryId;
	private boolean purchased;
	private String isbn;
	private int ranks;
	
	public InventoryDto(int inventoryId, boolean purchased, String isbn, int ranks) {
		super();
		this.inventoryId = inventoryId;
		this.purchased = purchased;
		this.isbn = isbn;
		this.ranks = ranks;
	}
	public InventoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public boolean isPurchased() {
		return purchased;
	}
	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getRanks() {
		return ranks;
	}
	public void setRanks(int ranks) {
		this.ranks = ranks;
	}

	

}
