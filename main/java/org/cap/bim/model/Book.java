package org.cap.bim.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book 
{
	@Id
	@Column(name="ISBN",length = 13 )
	private String isbn;
	
	@Column(name="Title",nullable = false,length = 70)
	private String title;
	
	@Column(name="Description",length = 100)
	private String description;
	
		
	@Column(name="Edition")
	private char edition ;
	
	
	
	
	@Column(name="PublisherID")
	private int publisherId;
	
	@Column(name="Category")
	private int catId;
	 
	
	
	
	
	@ManyToOne
	@JoinColumn(name="Category",referencedColumnName = "CatID",insertable = false,updatable =   false)
	private Category category;
	
	
    @ManyToOne
	@JoinColumn(name="PublisherID",referencedColumnName = "PublisherID",insertable = false,updatable = false)
    //@JsonBackReference
    private Publisher publisher;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "book")
   // @JsonBackReference
   private  List<BookReview> bookReviews=new ArrayList<>();
    
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "book")
    @JsonManagedReference
   private  List<ShoppingCart> Shoppingcarts=new ArrayList<>();
    
    
	
	


	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Book(String isbn, String title, String description, char edition, Category category, Publisher publisher) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.edition = edition;
		this.category = category;
		this.publisher = publisher;
	}



	public int getPublisherId() {
		return publisherId;
	}



	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}



	public int getCatId() {
		return catId;
	}



	public void setCatId(int catId) {
		this.catId = catId;
	}



	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getEdition() {
		return edition;
	}

	public void setEdition(char edition) {
		this.edition = edition;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
	
	
	

}
	
	
	