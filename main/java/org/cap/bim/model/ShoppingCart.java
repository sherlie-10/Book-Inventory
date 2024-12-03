package org.cap.bim.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="shoppingcart") 
@IdClass(ShoppingCartKey.class)
public class ShoppingCart  
{
	@Id
	@Column(name="UserID")
	private int userId;
	
	@Id
	@Column(name="ISBN")
	private String ISBN;
	
	
	
	@ManyToOne
	//@JsonBackReference
	@JoinColumn(name="ISBN",referencedColumnName = "ISBN",insertable = false,updatable = false)
	private Book book;
	
	public ShoppingCart() {
		super();
	}
	
	public ShoppingCart(int userId, String iSBN) {
		super();
		this.userId = userId;
		this.ISBN = iSBN;
	}

	public ShoppingCart(int userId, String iSBN, Book book) {
		super();
		this.userId = userId;
		this.ISBN = iSBN;
		this.book = book;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}	
	
	
}
