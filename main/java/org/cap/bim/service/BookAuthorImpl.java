package org.cap.bim.service;

import java.util.List;
import java.util.Optional;

import org.cap.bim.model.Book;
import org.cap.bim.model.BookAuthor;
import org.cap.bim.repository.BookRepository;
import org.cap.bim.repository.IBookAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookAuthorImpl implements IBookAuthorService 
{
	@Autowired
	private IBookAuthorRepository bookAuthorRepository;
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookAuthor addBookAuthor(BookAuthor bookAuthor) {
		
		BookAuthor bookAuthor1=new BookAuthor();
		bookAuthor1.setIsbn(bookAuthor.getIsbn());
		bookAuthor1.setAuthorId(bookAuthor.getAuthorId());
		bookAuthor1.setPrimaryAuthor(bookAuthor.getPrimaryAuthor());
		BookAuthor bookAuthor2=bookAuthorRepository.save(bookAuthor);
//			return bookAuthor2;
		return bookAuthor2;
		
	}
 
	@Override
	public List<BookAuthor> getAllBookAuthors() {
		return bookAuthorRepository.findAll();
	}
	
	

}
