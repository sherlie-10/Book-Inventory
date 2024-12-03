package org.cap.bim.repository;

import java.util.List;

import org.cap.bim.model.ShoppingCart;
import org.cap.bim.model.ShoppingCartKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartKey>{
	
	/*
	@Query("SELECT b.title FROM ShoppingCart sc JOIN sc.book b WHERE sc.userId= ?1")
	List<String> getUserShoppingData(Integer userId);
	*/
	
	@Query("SELECT b.title ,i.bookcondition.price,sc.userId, i.inventoryId,b.isbn FROM ShoppingCart sc " +
	        "JOIN sc.book b " +
	        "JOIN Inventory i ON b.isbn = i.isbn " +
	        "WHERE sc.userId = ?1")
	List<Object[]> getUserShoppingData( Integer userId);

//
//    @Query("DELETE FROM ShoppingCart s WHERE s.ISBN = ?1")
//    void deleteItemFromcart(String Isbn);
    
    void deleteByISBN(String ISBN);

	
    
    
	//@Query("SELECT i.inventoryId from Inventory i where i.book.")
	List<ShoppingCart> findByUserId (Integer userId);
}
