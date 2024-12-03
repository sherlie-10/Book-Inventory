package org.cap.bim.exception;

public class ShoppingCartNotFoundException extends RuntimeException{
	public ShoppingCartNotFoundException(String msg) {
		super(msg);
	}
}
