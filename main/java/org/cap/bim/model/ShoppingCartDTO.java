package org.cap.bim.model;

import java.util.Objects;

public class ShoppingCartDTO 
{
	private int userId;
	private String isbn;
	
	

	
	public ShoppingCartDTO(int userId, String isbn) {
		super();
		this.userId = userId;
		this.isbn = isbn;
	}
	public ShoppingCartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	
	
	
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public String getIsbn() {
//		return isbn;
//	}
//	public void setIsbn(String isbn) {
//		this.isbn = isbn;
//	}
//	public ShoppingCartDTO(int userId, String isbn) {
//		super();
//		this.userId = userId;
//		this.isbn = isbn;
//	}
//	public ShoppingCartDTO() {
//		super();
//	}
//	
//	public ShoppingCartDTO(String isbn) {
//		super();
//		this.isbn = isbn;
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(isbn, userId);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ShoppingCartDTO other = (ShoppingCartDTO) obj;
//		return isbn == other.isbn && userId == other.userId;
//	}
//	
	
}
