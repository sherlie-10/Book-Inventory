package org.cap.bim.model;

public class BookDto 
{
	private String isbn;
	private String title;
	private String description;
	private char edition ;
	private int publisherId;
	private int catId;
	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
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
	
	




}
