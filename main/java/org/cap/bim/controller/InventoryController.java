package org.cap.bim.controller;

import java.util.List;

import org.cap.bim.model.Book;
import org.cap.bim.model.Inventory;
import org.cap.bim.model.InventoryDto;
import org.cap.bim.model.State;
import org.cap.bim.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/bookinventory")
@RestController
public class InventoryController
{
	
	@Autowired
	private IInventoryService iInventoryService;
	
	@PostMapping("/post")
	public ResponseEntity<Inventory> createState(@RequestBody InventoryDto inventoryDto)
	{
		Inventory inventory=new Inventory();
		inventory.setIsbn(inventoryDto.getIsbn());
		inventory.setPurchased(inventoryDto.isPurchased());
		inventory.setRanks(inventoryDto.getRanks());
		
		Inventory inventory1=iInventoryService.crateNewInventory(inventory);
	
		if (inventory1!=null)
		{
			return new ResponseEntity("Book inventory added successfully", HttpStatus.OK);

		}
		return new ResponseEntity("Book Inventory Object creation Error!",
				HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Inventory>> getAllBooks()
	{
		List<Inventory> inventory= iInventoryService.getInventoryData();
		if(inventory!=null)
		{
			return new ResponseEntity<List<Inventory>>(inventory,HttpStatus.OK);
		}
		return new ResponseEntity("Empty ",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/availableinventory")
	public ResponseEntity<List<Inventory>> getAvailableInventoryData()
	{
		List<Inventory> inventory= iInventoryService.getAvailableInventoryData();
		if(inventory!=null)
		{
			return new ResponseEntity<List<Inventory>>(inventory,HttpStatus.OK);
		}
		return new ResponseEntity("Empty ",HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/{inventoryId}")
	public ResponseEntity<Inventory> findInventoryById(@PathVariable("inventoryId")Integer inventoryId){
		Inventory inventory=iInventoryService.findInventoryById(inventoryId);
		
		if(inventory==null) {
			return new ResponseEntity("Sorry! inventoryId is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);

	}
	
	
	@PutMapping("/update/purchased/{inventoryId}")
	public ResponseEntity<Inventory> updateStateByID(@PathVariable("inventoryId")Integer inventoryId,@RequestBody InventoryDto inventoryDto)
	{
		Inventory inventory=new Inventory() ;
		inventory.setPurchased(inventoryDto.isPurchased());
		Inventory inventory2=iInventoryService.updatePurchasedById(inventoryId,inventory);
		
		if(inventory2==null) {
			return new ResponseEntity("Sorry! inventoryId is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Inventory>(inventory2, HttpStatus.OK);

	}
	

}
