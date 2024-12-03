package org.cap.bim.service;

import java.util.List;
import java.util.Optional;


import org.cap.bim.exception.BookConditionNotFoundException;
import org.cap.bim.exception.BookNotFoundException;
import org.cap.bim.exception.InventoryNotFoundException;
import org.cap.bim.exception.StateNotFoundException;
import org.cap.bim.model.Book;
import org.cap.bim.model.Inventory;
import org.cap.bim.repository.BookRepository;
import org.cap.bim.repository.IBookConditionRepository;
import org.cap.bim.repository.BookRepository;
import org.cap.bim.repository.IInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryImpl implements IInventoryService 
{
	@Autowired
	private IInventoryRepository inventoryRepository;
	
	
	
	@Autowired
	private BookRepository bookRepository;
	
	private IBookConditionRepository bookConditionRepository;

	@Override
	public Inventory crateNewInventory(Inventory inventory) 
	{
		Optional<Book> book=bookRepository.findById(inventory.getIsbn());
		
		if(book.isEmpty())
		{
			throw new BookNotFoundException("Given Book is not present in Book List");
		}
		
		     inventory.setIsbn(book.get().getIsbn());
		     inventory.setRanks(inventory.getRanks());
			inventoryRepository.save(inventory);
	
		return inventory;
	}

	@Override
	public Inventory findInventoryById(Integer InventoryId) 
	{

	      Optional<Inventory> inventory = inventoryRepository.findById(InventoryId);
	    if(inventory.isPresent())
	    {
	    	return inventory.get();
	    }
		throw new InventoryNotFoundException("No Inventory is Found with this InventoryId");
		
	}

	@Override
	public Inventory updatePurchasedById(Integer InventoryId, Inventory inventory) 
	{
	      Optional<Inventory> inventory1 = inventoryRepository.findById(InventoryId);
	      if(inventory1.isPresent())
		    {
	    	  inventory1.get().setPurchased(inventory.isPurchased());
	    	  inventoryRepository.save(inventory1.get());
		    	return inventory1.get();
		    }
		return inventory;
	}

	@Override
	public List<Inventory> getInventoryData() 
	{
		List<Inventory> inventories=inventoryRepository.GetinventoriesAvailable();
		if(inventories!=null)
		{
			return inventories;
		}
		
		throw new InventoryNotFoundException(" Inventory is empty");

		
	}

	@Override
	public List<Inventory> getAvailableInventoryData() {
		List<Inventory> inventories=inventoryRepository.findAll();
		if(inventories!=null)
		{
			return inventories;
		}
		
		throw new InventoryNotFoundException(" Inventory is empty");

	}

}
