package org.cap.bim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.cap.bim.exception.PurchaseLogNotFoundException;
import org.cap.bim.exception.UserNotFoundException;
import org.cap.bim.model.Inventory;
import org.cap.bim.model.PurchaseLog;
import org.cap.bim.model.PurchaseLogDTO;
import org.cap.bim.model.User;
import org.cap.bim.repository.IInventoryRepository;
import org.cap.bim.repository.IPurchaseLogRepository;
import org.cap.bim.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseLogImpl implements IPurchaseLogService{
	
	@Autowired
	private IPurchaseLogRepository purchaseLogRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IInventoryRepository inventoryRepository;
	
	@Override
	public PurchaseLog addPurchaseLog(PurchaseLogDTO purchaseLogDto) {
		Optional<User> user=userRepository.findById(purchaseLogDto.getUserId());
		if(user.isEmpty()) {
			throw new UserNotFoundException("User not found with this userId!"); 
		}
		PurchaseLog purchaseLog=new PurchaseLog();
		purchaseLog.setInventoryId(purchaseLogDto.getInventoryId());
		purchaseLog.setUserId(purchaseLogDto.getUserId());
		PurchaseLog purchaseLog1=purchaseLogRepository.save(purchaseLog);
		if(purchaseLog1!=null) {
			return purchaseLog1;
		}
		throw new PurchaseLogNotFoundException("PurchaseLog not found with this userId!");
	}

	@Override
	public List<PurchaseLogDTO> getPurchaseLogByUserId(Integer userId) {
	    List<PurchaseLog> purchaseLogs = purchaseLogRepository.findByUserId(userId);

	    if (purchaseLogs.isEmpty()) {
	        throw new PurchaseLogNotFoundException("PurchaseLog not found with this userId!");
	    }
	    List<PurchaseLogDTO> purchaseLogDTOs = new ArrayList<>();
	    
	    for (PurchaseLog purchaseLog : purchaseLogs) {
	        PurchaseLogDTO dto = new PurchaseLogDTO();
	        dto.setUserId(purchaseLog.getUserId()); 
	        dto.setInventoryId(purchaseLog.getInventoryId());
	        purchaseLogDTOs.add(dto);
	    }
	    return purchaseLogDTOs;
	}

	@Override
	public List<PurchaseLogDTO> updateInventoryIdByUserId(Integer userId, PurchaseLogDTO purchaseLogDto) {
	    List<PurchaseLog> logs = purchaseLogRepository.findByUserId(userId);
	    Optional<Inventory> inventory=inventoryRepository.findById(purchaseLogDto.getInventoryId());
	    if (logs.isEmpty()) {
	        throw new PurchaseLogNotFoundException("PurchaseLogs not found with this userId!");
	    }
	    if(inventory.isEmpty()) {
	    	throw new PurchaseLogNotFoundException("Invalid inventoryId");
	    }
	    List<PurchaseLogDTO> purchaseLogDTOs = new ArrayList<>();
	    for (PurchaseLog purchaseLog : logs) {
	        PurchaseLogDTO dto = new PurchaseLogDTO();
	        dto.setUserId(purchaseLog.getUserId()); 
	        dto.setInventoryId(purchaseLogDto.getInventoryId());
	        purchaseLogDTOs.add(dto);
	    }
	    return purchaseLogDTOs;
	}

	@Override
	public List<Object[]> getPurchaseDetailsByUser(Integer userId) 
	{
		List<Object[]> purchasedetails=purchaseLogRepository.getPurchaseHistoryDetailsByuserId(userId);
		if(purchasedetails!=null)
		{
			return purchasedetails;
		}
        throw new PurchaseLogNotFoundException("PurchaseHistory Not Present");

	}
}
