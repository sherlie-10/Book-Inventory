package org.cap.bim.repository;

import java.util.List;

import org.cap.bim.model.PurchaseLog;
import org.cap.bim.model.PurchaseLogKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPurchaseLogRepository extends JpaRepository<PurchaseLog, PurchaseLogKey>{
	
	
	@Query("SELECT i.book.isbn,i.book.title,i.book.description,i.bookcondition.price FROM Inventory i JOIN PurchaseLog p ON i.inventoryId=p.inventoryId WHERE p.userId= ?1")
	List<Object[]>  getPurchaseHistoryDetailsByuserId(Integer userId);
	
	

	
	List<PurchaseLog> findByUserId(Integer userId);
}
