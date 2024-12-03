package org.cap.bim.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="publisher") 
public class Publisher 
{
	@Id
	@Column(name="PublisherID")
	private int publisherId;
	
	@Column(name="Name",nullable = false)
	private String name;
	
	@Column(name="City")
	private String city ;
	
	
	@Column(name="state_code") 
	private String stateCode;

	
	@ManyToOne
	@JoinColumn(name = "state_code",insertable = false,updatable  = false)
	@JsonBackReference
	private State state; 

	@JsonIgnore
	@OneToMany(mappedBy = "publisher")
	@JsonManagedReference
	private List<Book> Books=new ArrayList<>();

	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Publisher(int publisherId, String name, String city, String stateCode, State state, List<Book> books) {
		super();
		this.publisherId = publisherId;
		this.name = name;
		this.city = city;
		this.stateCode = stateCode;
		this.state = state;
		Books = books;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

//	public List<Book> getBooks() {
//		return Books;
//	}

	public void setBooks(List<Book> books) {
		Books = books;
	}
	
	
	
}	