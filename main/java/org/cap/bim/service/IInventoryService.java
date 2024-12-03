package org.cap.bim.service;

import java.util.List;

import org.cap.bim.model.Inventory;
import org.cap.bim.model.State;

public interface IInventoryService 
{
	public Inventory crateNewInventory(Inventory inventory);
	public List<Inventory> getInventoryData();
	public Inventory findInventoryById(Integer InventoryId);
	public Inventory updatePurchasedById(Integer InventoryId,Inventory inventory);
	
	public List<Inventory> getAvailableInventoryData();



}
