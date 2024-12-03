package org.cap.bim.model;

import java.io.Serializable;
import java.util.Objects;

public class BookReviewId implements Serializable
{
	private String isbn;
	private  int reviewerId;
	
	
	public BookReviewId(String isbn, int reviewerId) {
		super();
		this.isbn = isbn;
		this.reviewerId = reviewerId;
	}
	public BookReviewId() {
		super();
		// TODO Auto-generated constructor stub
		
		
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public int hashCode() {
		return Objects.hash(isbn, reviewerId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookReviewId other = (BookReviewId) obj;
		return Objects.equals(isbn, other.isbn) && reviewerId == other.reviewerId;
	}
	public int getReviewerId() {
		return reviewerId;
	}
	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
	}
	
	
	
	
	
}
