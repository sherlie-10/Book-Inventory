package org.cap.bim.model;

import java.io.Serializable;
import java.util.Objects;

public class BookAuthorId implements Serializable
{
	
	private String isbn;
	private int authorId;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(authorId, isbn);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookAuthorId other = (BookAuthorId) obj;
		return authorId == other.authorId && isbn == other.isbn;
	}
	public BookAuthorId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
