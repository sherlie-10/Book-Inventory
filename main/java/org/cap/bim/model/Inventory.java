package org.cap.bim.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="InventoryID")
	private int inventoryId;
	
	@Column(name="Purchased",columnDefinition = "tinyint(1) default 0")
	private boolean purchased;
	
	
	@Column(name="ISBN")
	private String isbn;
	
	@Column(name="Ranks")
	private int ranks;
	
	@ManyToOne
	@JoinColumn(name = "Ranks",referencedColumnName = "Ranks",insertable = false,updatable = false)
	//@JsonBackReference
	private  BookCondition bookcondition;
	
	@ManyToOne
	@JoinColumn(name = "ISBN",referencedColumnName = "ISBN",insertable = false,updatable = false)
	//@JsonBackReference
	private Book book;

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public boolean isPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getRanks() {
		return ranks;
	}

	public void setRanks(int ranks) {
		this.ranks = ranks;
	}

	public BookCondition getBookcondition() {
		return bookcondition;
	}

	public void setBookcondition(BookCondition bookcondition) {
		this.bookcondition = bookcondition;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
	
	
	
}	