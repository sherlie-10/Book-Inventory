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
@Table(name="bookauthor")
@IdClass(BookAuthorId.class)
public class BookAuthor {
		
		@Id
		@Column(name="ISBN")
		private String isbn;
		
		@Id
		@Column(name="AuthorID")
		private int authorId;
		
		
		@Column(name="primary_author")
		private char primaryAuthor;
		
		
		
		@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="ISBN",referencedColumnName = "ISBN",insertable = false,updatable = false)
	private Book  book;
		
		@ManyToOne
		@JsonBackReference
	@JoinColumn(name="AuthorID" ,referencedColumnName = "authorID",insertable = false,updatable = false)
	private Author author;
		
	
	
	
	
	
	
	
	public BookAuthor() {
		super();
		// TODO Auto-generated constructor stub
	}






	public BookAuthor(Book book, Author author, char primaryAuthor) {
		super();
		this.book = book;
		this.author = author;
		this.primaryAuthor = primaryAuthor;
	}






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






	public Book getBook() {
		return book;
	}






	public void setBook(Book book) {
		this.book = book;
	}






	public Author getAuthor() {
		return author;
	}






	public void setAuthor(Author author) {
		this.author = author;
	}






	public char getPrimaryAuthor() {
		return primaryAuthor;
	}






	public void setPrimaryAuthor(char primaryAuthor) {
		this.primaryAuthor = primaryAuthor;
	}






//	@Override
//	public String toString() {
//		return "BookAuthor [isbn=" + isbn + ", authorId=" + authorId + ", primaryAuthor=" + primaryAuthor + "]";
//	}



	
	


}
