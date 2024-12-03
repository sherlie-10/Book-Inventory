package org.cap.bim.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category" )
public class Category 
{
	
	@Id
	@Column(name="CatID")
	private int catId;
	
	@Column(name="cat_description",length =24)
	private String catDescription;
	
	

	@JsonIgnore
	@OneToMany(mappedBy = "category")
	//@JsonManagedReference
	List<Book> Books=new ArrayList<>();
	
	public Category() {
		super();
	}
	
	
	
	
	public Category(int catId, String catDescription) {
		super();
		this.catId = catId;
		this.catDescription=catDescription;
		
	}




	public Category( String catDescription) {
		super();
		this.catDescription = catDescription;
	
	}
	
	
	public int getCatId() {
		return catId;
	}
	
	
	public void setCatId(int catId) {
		this.catId = catId;
	}
	
	
	public String getCatDescription() {
		return catDescription;
	}
	
	
	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}
	
	
//	@Override
//	public String toString() {
//		return "Category [catId=" + catId + ", catDescription=" + catDescription + "]";
//	}
//	
	
	
	
	
}
