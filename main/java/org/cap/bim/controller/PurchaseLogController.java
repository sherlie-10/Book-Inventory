package org.cap.bim.controller;

import java.util.List;

import org.cap.bim.model.PurchaseLog;
import org.cap.bim.model.PurchaseLogDTO;
import org.cap.bim.service.IPurchaseLogService;
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
@RequestMapping("/api/purchaselog")
@RestController
public class PurchaseLogController {
	
	@Autowired
	private IPurchaseLogService purchaseLogService;
	
	@PostMapping("/post")
	public ResponseEntity<String> addPurchaseLog(@RequestBody PurchaseLogDTO purchaseLogDto){
		PurchaseLog purchaseLog=purchaseLogService.addPurchaseLog(purchaseLogDto);
		if(purchaseLog!=null) {
			return new ResponseEntity<String>("Purchase Log added successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("PurchaseLog creation error!",HttpStatus.NOT_FOUND);
	}
	
	

	@GetMapping("purchasehistory/{userId}")
	public ResponseEntity <List<Object []>> g(@PathVariable ("userId") Integer userId){
		List<Object []> purchaseLogs=purchaseLogService.getPurchaseDetailsByUser(userId);
		if(purchaseLogs.isEmpty()) {
			return new ResponseEntity("PurchaseLog not found for userId : "+userId,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object[]>>(purchaseLogs,HttpStatus.OK);
	}
	
	
	
	@GetMapping("{userId}")
	public ResponseEntity <List<PurchaseLogDTO>> getPurchaseLogById(@PathVariable ("userId") Integer userId){
		List<PurchaseLogDTO> purchaseLogs=purchaseLogService.getPurchaseLogByUserId(userId);
		if(purchaseLogs.isEmpty()) {
			return new ResponseEntity("PurchaseLog not found for userId : "+userId,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<PurchaseLogDTO>>(purchaseLogs,HttpStatus.OK);
	}
	
	@PutMapping("update/inventoryid/{userId}")
	public ResponseEntity <List<PurchaseLogDTO>> updateInventoryIdByUserId(@PathVariable ("userId") Integer userId,@RequestBody PurchaseLogDTO purchaseLogDto){
		List<PurchaseLogDTO> purchaseLogs=purchaseLogService.updateInventoryIdByUserId(userId,purchaseLogDto);
		if(purchaseLogs.isEmpty()) {
			return new ResponseEntity("PurchaseLog not found for userId : "+userId,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<PurchaseLogDTO>>(purchaseLogs,HttpStatus.OK);
	}
	
	
	

	
}
