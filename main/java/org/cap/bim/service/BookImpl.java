package org.cap.bim.service;

import java.util.ArrayList;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.cap.bim.exception.BookNotFoundException;
import org.cap.bim.model.Book;
import org.cap.bim.model.Category;
import org.cap.bim.model.Publisher;
import org.cap.bim.repository.BookRepository;
import org.cap.bim.repository.ICategoryRepository;
import org.cap.bim.repository.IPublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookImpl implements IBookService
{
	@Autowired    
	private BookRepository bookRepository;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private IPublisherRepository publisherRepository;

	
	@Override
	public Book createbookData(Book book)
	{
		
		
		
		
//		Optional<Publisher> publisher =iPublisherRepository.findById(book.getPublisherId());
//		
//	    book.setPublisherId(publisher.get().getPublisherId());
//	
//		Optional<Category> category=null; 
//	
//	if(book.getCategory()!=null)
//		category=categoryRepository.findById(book.getCatId());
//			
//		
//		
//		book.setCatId(category.get().getCatId());
		
		if(book.getIsbn()==null || book.getIsbn().isEmpty())
		{
			throw new BookNotFoundException("Please Enter ISBN") ;

		   
		}
		return bookRepository.save(book);
		
		
		
		
	}

	@Override
	public List<Book> getAllBooks() 
	{
		List<Book> books=bookRepository.findAll();
		
	
		return books;
		
	}

	@Override
	public Book getBookByIsbn(String isbn) 
	{
		Book book=bookRepository.findById(isbn).get();
		if(book!=null)
		{
			
			return book;
		}
		throw new BookNotFoundException("Book Not Found") ;
		
		
		
	}

	@Override
	public Book getBookByTitle(String title)
	{
		List<Book> books=bookRepository.findAll();
		
		if(books!=null)
		{
			for (Book book : books) 
			{
				if(book.getTitle().equals(title))
				{
					return book;
				}
				
			}
		}
		
		throw new BookNotFoundException("Book Not Found with this title");
		
		
	}

	@Override
	public List<Book> getBooksByCategory(Integer category) 
	{
		List<Book> books=bookRepository.findAll();
		List<Book> foundBooks=new ArrayList<>();
		
		if(books!=null)
		{
			for (Book book : books) 
			{
				if(book.getCategory().getCatId()==category)
				{
					foundBooks.add(book);
					
				}
				
			}
		}
		if(foundBooks.isEmpty())
		{
			throw new BookNotFoundException("No Books fund with Category");
		}
		return foundBooks;
		
		
	}

	@Override
	public List<Book> getBooksByPublisherId(Integer publisherId) {
	    List<Book> books = bookRepository.findAll();
	    List<Book> foundBooks = new ArrayList<>();

	    if (books != null) {
	        for (Book book : books) {
	            if (book.getPublisher() != null && book.getPublisher().getPublisherId()==publisherId)
	            {
	                foundBooks.add(book);
	            }
	        }
	    }

	    if (foundBooks.isEmpty()) {
	        throw new BookNotFoundException("No Books found for the given publisherId");
	    }

	    return foundBooks;
	}

	@Override
	public Book updateBookByisbn(String isbn, Book book) {
	    Optional<Book> optionalBook = bookRepository.findById(isbn);
	    
	    if (optionalBook.isPresent()) {
	        Book existingBook = optionalBook.get();
	        existingBook.setTitle(book.getTitle());
	        bookRepository.save(existingBook);
	        return existingBook;
	    } else {
	        throw new BookNotFoundException("Book Not Found");
	    }
	}


	@Override
	public Book updateBookDescrition(String isbn,Book book)
	{
		 Optional<Book> optionalBook = bookRepository.findById(isbn);
		    
		    if (optionalBook.isPresent()) 
		    {
		        Book existingBook = optionalBook.get();
		        existingBook.setDescription(book.getDescription());
		        bookRepository.save(existingBook);
		        return existingBook;
		    } else {
		        throw new BookNotFoundException("Book Not Found");
		    }
		
	}

	@Override
	public Book updateBookcategory(String isbn,Book book)
	{
		Optional<Category> category=categoryRepository.findById(book.getCatId());
	    Optional<Book> optionalBook = bookRepository.findById(isbn);

		if(category!=null && optionalBook.isPresent())
		{
			Book book1=optionalBook.get();
			book1.setCatId(category.get().getCatId());
			bookRepository.save(book1);
			return book1;
			
		}
				
        throw new BookNotFoundException("Book Not Found");
		
	
	}

	@Override
	public Book updateBookedition(String isbn,Book book) 
	{
		Optional<Book> optionalBook = bookRepository.findById(isbn);
	    
	    if (optionalBook.isPresent()) 
	    {
	        Book existingBook = optionalBook.get();
	        existingBook.setEdition(book.getEdition());
	        bookRepository.save(existingBook);
	        return existingBook;
	    } else {
	        throw new BookNotFoundException("Book Not Found");
	    }
		
	}

	@Override
	public Book udpdateBookPublisher(String isbn,Book book) {
		Publisher publisher=publisherRepository.findById(book.getPublisherId()).get();
	    Optional<Book> optionalBook = bookRepository.findById(isbn);

		if(publisher!=null && optionalBook.isPresent())
		{
			Book book1=optionalBook.get();
			book1.setPublisherId(publisher.getPublisherId());
			bookRepository.save(book1);
			return book1;
			
		}
				
        throw new BookNotFoundException("Book Not Found");
	}

	@Override
	public List<Object[]> getBookDetails(String isbn) {
		List<Object[]> bookdetails=bookRepository.findBookDetailsByIsbn(isbn);
		
		if(bookdetails!=null)
		{
			return bookdetails;
		}
        throw new BookNotFoundException("Book Not Found");

	}
	
	
	

}
