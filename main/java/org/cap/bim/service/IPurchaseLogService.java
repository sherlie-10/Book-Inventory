package org.cap.bim.service;

import java.util.List;

import org.cap.bim.model.PurchaseLog;
import org.cap.bim.model.PurchaseLogDTO;

public interface IPurchaseLogService {
	public PurchaseLog addPurchaseLog(PurchaseLogDTO purchaseLogDto);
	public List<PurchaseLogDTO> getPurchaseLogByUserId(Integer userId);
	public List<PurchaseLogDTO> updateInventoryIdByUserId(Integer userId,PurchaseLogDTO purchaseLogDto);
	
	
	
	public List<Object[]> getPurchaseDetailsByUser(Integer userId);
}
