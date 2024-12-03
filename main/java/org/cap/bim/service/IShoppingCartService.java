package org.cap.bim.service;

import java.util.List;

import org.cap.bim.model.ShoppingCart;
import org.cap.bim.model.ShoppingCartDTO;

public interface IShoppingCartService {
	public ShoppingCart addToCart(ShoppingCartDTO shoppingCartDto);
	public List<ShoppingCartDTO> getCartByUserId(Integer userId);
	public List<ShoppingCartDTO> updateISBNByUserId(Integer userId,ShoppingCartDTO shoppingCartDto);
	
	public List<Object[]> getUsercartData(Integer userId);
	
	void deleteItemFromcart(String Isbn);
}
