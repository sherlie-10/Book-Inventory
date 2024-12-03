package org.cap.bim.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.cap.bim.model.Book;
import org.cap.bim.model.Inventory;
import org.cap.bim.repository.BookRepository;
import org.cap.bim.repository.IBookReviewRepository;
import org.cap.bim.repository.IInventoryRepository;
import org.cap.bim.service.InventoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class InventoryTest 
{
	
	
	@Mock
	private IInventoryRepository inventoryRepository;
	
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private InventoryImpl inventoryImpl;
	
	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
    public void testCreateNewInventory() {
        // Test when the book is found
        String isbn = "123456789";
        Book mockBook = new Book();
        mockBook.setIsbn(isbn);

        Inventory mockInventory = new Inventory();
        mockInventory.setIsbn(isbn);
        mockInventory.setRanks(6);

        when(bookRepository.findById(isbn)).thenReturn(Optional.of(mockBook));
        when(inventoryRepository.save(mockInventory)).thenReturn(mockInventory);

        Inventory result = inventoryImpl.crateNewInventory(mockInventory);

        assertEquals(isbn, result.getIsbn());
        assertEquals(6, result.getRanks());
    }
	
	
	
	 @Test
	    public void testFindInventoryById() {
	        // Test when the inventory is found
	        Integer inventoryId = 1;
	        Inventory mockInventory = new Inventory();
	        mockInventory.setInventoryId(inventoryId);

	        when(inventoryRepository.findById(inventoryId)).thenReturn(Optional.of(mockInventory));

	        Inventory result = inventoryImpl.findInventoryById(inventoryId);

	        assertEquals(inventoryId, result.getInventoryId() );
	    }
	 
	 

	    @Test
	    public void testUpdatePurchasedById() {
	        Integer inventoryId = 1;
	        Inventory existingInventory = new Inventory();
	        existingInventory.setInventoryId(inventoryId);
	        existingInventory.setPurchased(false);

	        Inventory updatedInventory = new Inventory();
	        updatedInventory.setPurchased(true);

	        when(inventoryRepository.findById(inventoryId)).thenReturn(Optional.of(existingInventory));
	        when(inventoryRepository.save(existingInventory)).thenReturn(existingInventory);

	        Inventory result = inventoryImpl.updatePurchasedById(inventoryId, updatedInventory);

	        assertTrue(result.isPurchased(), "Purchased status should be updated to true");
	    }
	
	
	

}
