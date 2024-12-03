package org.cap.bim.service;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.cap.bim.exception.ShoppingCartNotFoundException;
import org.cap.bim.exception.UserNotFoundException;
import org.cap.bim.model.Book;
import org.cap.bim.model.ShoppingCart;
import org.cap.bim.model.ShoppingCartDTO;
import org.cap.bim.model.User;
import org.cap.bim.repository.BookRepository;
import org.cap.bim.repository.IShoppingCartRepository;
import org.cap.bim.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ShoppingCartImpl implements IShoppingCartService{

	@Autowired
	private IShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public ShoppingCart addToCart(ShoppingCartDTO shoppingCartDto) 
	{
		System.out.println("isb in service***********"+shoppingCartDto.getIsbn());
		System.out.println("isb***********"+shoppingCartDto.getUserId());

		Optional<User> user=userRepository.findById(shoppingCartDto.getUserId());
		if(user.isEmpty()) {
			throw new UserNotFoundException("User not found with this userId!"); 
		}
		ShoppingCart shoppingCart=new ShoppingCart();
		shoppingCart.setISBN(shoppingCartDto.getIsbn());
		System.out.println("isbn:-"+shoppingCart.getISBN());
		shoppingCart.setUserId(shoppingCartDto.getUserId());
		ShoppingCart shoppingCart1=shoppingCartRepository.save(shoppingCart);
		if(shoppingCart1!=null) {
			return shoppingCart1;
		}
		throw new ShoppingCartNotFoundException("ShoppingCart is empty for this userId!");
	}

	@Override
	public List<ShoppingCartDTO> getCartByUserId(Integer userId) {
		List<ShoppingCart> carts=shoppingCartRepository.findByUserId(userId);
		if(carts.isEmpty()) {
			throw new ShoppingCartNotFoundException("ShoppingCart not found with this userId!");
		}
		List<ShoppingCartDTO> cartDtos=new ArrayList<>();
		
		for(ShoppingCart shoppingCart:carts) {
			ShoppingCartDTO dto=new ShoppingCartDTO();
			dto.setUserId(shoppingCart.getUserId());
			dto.setIsbn(shoppingCart.getISBN());
			cartDtos.add(dto);
		}
		return cartDtos;
	}

	@Override
	public List<ShoppingCartDTO> updateISBNByUserId(Integer userId, ShoppingCartDTO shoppingCartDto) {
		List<ShoppingCart> carts=shoppingCartRepository.findByUserId(userId);
		Optional<Book> book=bookRepository.findById(shoppingCartDto.getIsbn());
		if(carts.isEmpty()) {
			throw new ShoppingCartNotFoundException("ShoppingCart is empty for the userId : "+userId);
		}
		if (book.isEmpty()) {
			throw new ShoppingCartNotFoundException("Invalid ISBN!");
		}
		List<ShoppingCartDTO> cartDTOs=new ArrayList<>();
		
		for(ShoppingCart cart:carts) {
			ShoppingCartDTO dto =new ShoppingCartDTO();
			dto.setUserId(cart.getUserId());
			dto.setIsbn(shoppingCartDto.getIsbn());
			cartDTOs.add(dto);
		}
		return cartDTOs;
	}

	@Override
	public List<Object[]> getUsercartData(Integer userId)
	{
		List<Object[]> title=shoppingCartRepository.getUserShoppingData(userId);
		return title;
	}

	
	@Override
	public void deleteItemFromcart(String Isbn) 
	{
		shoppingCartRepository.deleteByISBN(Isbn);
		
	}

}
