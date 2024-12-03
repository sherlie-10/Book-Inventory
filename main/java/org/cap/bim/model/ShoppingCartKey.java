package org.cap.bim.model;

import java.io.Serializable;
import java.util.Objects;

public class ShoppingCartKey implements Serializable 
{
	private int userId;
	private String ISBN;
	
	public ShoppingCartKey() {
		super();
	}

	public ShoppingCartKey(int userId, String iSBN) {
		super();
		this.userId = userId;
		this.ISBN = iSBN;
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

//	@Override
//	public String toString() {
//		return "ShoppingCartKey [userId=" + userId + ", ISBN=" + ISBN + "]";
//	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCartKey other = (ShoppingCartKey) obj;
		return ISBN == other.ISBN && userId == other.userId;
	}
	
	
	
	
	
}
