package org.cap.bim.model;

import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="reviewer")
public class Reviewer 
{
	@Id
	@Column(name="reviewerid")
	private int reviewerid;
	
	@Column(name="Name",length = 20,nullable = false)
	private String name;
	
	@Column(name="employed_by",length = 30)
	private String employedBy;
	
	
	@OneToMany(mappedBy = "reviewer")
	@JsonManagedReference
	private List<BookReview> BookReviews= new ArrayList<>();
	
	
	
	public int getReviewerid() {
		return reviewerid;
	}
	public void setReviewerid(int reviewerid) {
		this.reviewerid = reviewerid;
	}
	public List<BookReview> getBookReviews() {
		return BookReviews;
	}
	public void setBookReviews(List<BookReview> bookReviews) {
		BookReviews = bookReviews;
	}
	public int getReviewerId() {
		return reviewerid;
	}
	public void setReviewerId(int reviewerId) {
		this.reviewerid = reviewerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployedBy() {
		return employedBy;
	}
	public void setEmployedBy(String employedBy) {
		this.employedBy = employedBy;
	}
	public Reviewer( String name, String employedBy) {
		super();
	
		this.name = name;
		this.employedBy = employedBy;
	}
	public Reviewer() {
		super();
	}
	
}
	