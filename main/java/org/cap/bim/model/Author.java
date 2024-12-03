package org.cap.bim.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	
	@Id
	@Column(name="authorID")
	private int authorId;
	
	@Column(name="first_name",nullable = false)
	private String firstName;
	
	@Column(name="last_name" ,nullable = false)
	private String lastName;
	
	@Column(name="Photo")
	private String 	photo;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "author")
	@JsonManagedReference
	List<BookAuthor> bookAuthors=new ArrayList<>();

	public Author() {
		super();
	}

	public Author(String firstName, String lastName, String photo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.photo = photo;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	

}
