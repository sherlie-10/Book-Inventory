package org.cap.bim.service;
import java.util.List;

import org.cap.bim.model.Author;
import org.cap.bim.model.Book;
 
public interface IAuthorService
{
	public Author addAuthor(Author author);
	public Author getAuthorById(Integer authorId);
	public List<Author> getAuthorByFirstName(String firstName);
	public List<Author> getAuthorByLastName(String lastName);
	public Author updateFirstNameById(Integer authorId,Author author);
	public Author updateLastNameById(Integer authorId,Author author);
	public List<Book> getAllBooks(Integer authorId);
	
	public List<Author> getAllAuthors();
}