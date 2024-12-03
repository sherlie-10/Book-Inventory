package org.cap.bim.service;

import java.util.List;

import org.cap.bim.model.Book;
;

public interface IBookService
{
	public Book createbookData(Book book);
	
	
	public List<Book> getAllBooks();
	public Book getBookByIsbn(String isbn);
	
	public Book getBookByTitle(String title);
	public List<Book> getBooksByCategory(Integer category);
	public List <Book> getBooksByPublisherId(Integer publisherId);
	
	public Book updateBookByisbn(String isbn,Book book);
	public Book updateBookDescrition(String isbn,Book book);
	public Book updateBookcategory(String isbn,Book book);
	public Book updateBookedition(String isbn,Book book);
	public Book udpdateBookPublisher(String isbn,Book book);
	
	public List<Object[]> getBookDetails(String isbn);
	

}
