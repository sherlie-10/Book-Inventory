package org.cap.bim.repository;

import java.util.List;

import org.cap.bim.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventoryRepository extends JpaRepository<Inventory, Integer>{

	
	@Query("SELECT i FROM Inventory i WHERE purchased=false ")
	List<Inventory> GetinventoriesAvailable();
	
}
