package org.cap.bim.model;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bookreview")
@IdClass(BookReviewId.class)
public class BookReview 
{
	
	@Id
	@Column(name="ISBN",nullable = false)
	private String isbn;
	
	@Id
	@Column(name="reviewerid",nullable = false)
	private int reviewerId;
	
		
	
	@Column(name="Rating")
	private int rating;
	
	@Column(name="Comments")
	private String comments;
	
	
	@ManyToOne()
	@JoinColumn(name="ISBN" ,referencedColumnName = "ISBN" ,insertable = false,updatable = false)
	@JsonBackReference
	private Book book;
	
	
	
	@ManyToOne()
	@JoinColumn(name="reviewerid" ,referencedColumnName = "reviewerid" ,insertable = false,updatable = false)
	@JsonBackReference
	private Reviewer reviewer;
	
	
	
	
	

	public BookReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookReview(String isbn, int reviewerId, int rating, String comments, Book book) {
		super();
		this.isbn = isbn;
		this.reviewerId = reviewerId;
		this.rating = rating;
		this.comments = comments;
		this.book = book;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}
	
	
	
	

}
