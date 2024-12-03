package org.cap.bim.controller;

import java.util.List;
import java.util.Map;

import org.cap.bim.model.PurchaseLogDTO;
import org.cap.bim.model.ShoppingCart;
import org.cap.bim.model.ShoppingCartDTO;
import org.cap.bim.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/shoppingcart")
@RestController
public class ShoppingCartController {
	@Autowired
	private IShoppingCartService shoppingCartService;
	
	@PostMapping("/post")
	public ResponseEntity<Map<String, String>> addToCart(@RequestBody ShoppingCartDTO shoppingCartDto)
	{
		System.out.println("isb NO***********"+shoppingCartDto.getIsbn());

		ShoppingCart shoppingCart=shoppingCartService.addToCart(shoppingCartDto);
		if(shoppingCart!=null) {
			return new ResponseEntity<Map<String, String>>(Map.of("message", "Shopping cart added successfully"), HttpStatus.CREATED);
		}
		return new ResponseEntity<Map<String, String>>(HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("{userId}")
	public ResponseEntity <List<ShoppingCartDTO>> getCartByUserId(@PathVariable ("userId") Integer userId){
		List<ShoppingCartDTO> shoppingCarts=shoppingCartService.getCartByUserId(userId);
		if(shoppingCarts.isEmpty()) {
			return new ResponseEntity("ShoppingCart is not found for the userId : "+userId,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ShoppingCartDTO>>(shoppingCarts,HttpStatus.OK);
	}
	
	
		
	
	
	
	@GetMapping("/usercart/{userId}")
	public ResponseEntity <List<Object[]>> getUsercartData(@PathVariable ("userId") Integer userId){
		List<Object[]> shoppingCarts=shoppingCartService.getUsercartData(userId);
		if(shoppingCarts.isEmpty()) {
			return new ResponseEntity("ShoppingCart is not found for the userId : "+userId,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object[]>>(shoppingCarts,HttpStatus.OK);
	}
	
	@PutMapping("/update/isbn/{userId}")
	public ResponseEntity<List<ShoppingCartDTO>> updateISBNByUserId(@PathVariable ("userId") Integer userId ,@RequestBody ShoppingCartDTO shoppingCartDto){
		List<ShoppingCartDTO> shoppingCarts=shoppingCartService.updateISBNByUserId(userId, shoppingCartDto);
		if(shoppingCarts.isEmpty()) {
			return new ResponseEntity("ShoppingCart is not found for the userId : "+userId,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ShoppingCartDTO>>(shoppingCarts,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletcartitem/{isbn}")
	public ResponseEntity  deleteItemFromCart(@PathVariable ("isbn") String isbn){
		             shoppingCartService.deleteItemFromcart(isbn);
//		if(shoppingCarts.isEmpty()) {
//			return new ResponseEntity("ShoppingCart is not found for the userId : "+userId,HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<List<ShoppingCartDTO>>(shoppingCarts,HttpStatus.OK);
					return null;
	}
	
	
	
}
