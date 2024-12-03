package org.cap.bim.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.cap.bim.exception.AuthorNotFoundException;
import org.cap.bim.model.Author;
import org.cap.bim.model.Book;
import org.cap.bim.model.BookAuthor;
import org.cap.bim.repository.IAuthorRespository;
import org.cap.bim.repository.IBookAuthorRepository;
import org.cap.bim.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorImpl implements IAuthorService

{
	@Autowired
	private IAuthorRespository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private IBookAuthorRepository bookAuthorRepository;
 
	@Override
	public Author addAuthor(Author author) {
		return authorRepository.save(author);
	}
 
	@Override
	public Author getAuthorById(Integer authorId) {
		Optional<Author> author=authorRepository.findById(authorId);
		if(author.isPresent()) {
			return author.get();
		}
		throw new AuthorNotFoundException("Author not found with authorId : "+ authorId);
	}
 
	@Override
	public List<Author> getAuthorByFirstName(String firstName) {
		List<Author> authors=authorRepository.findAll();
		List<Author> foundAuthors=new ArrayList<>();
		for(Author author:authors) {
			if(author.getFirstName().equals(firstName)) {
				foundAuthors.add(author);
			}
		}
		if(foundAuthors.isEmpty()) {
			throw new AuthorNotFoundException("Author not found with the first name : "+firstName);
		}
		return foundAuthors;
	}
 
	@Override
	public List<Author> getAuthorByLastName(String lastName) {
		List<Author> authors=authorRepository.findAll();
		List<Author> foundAuthors=new ArrayList<>();
		for(Author author:authors) {
			if(author.getLastName().equals(lastName)) {
				foundAuthors.add(author);
			}
		}
		if(foundAuthors.isEmpty()) {
			throw new AuthorNotFoundException("Author not found with the last name : "+lastName);
		}
		return foundAuthors;
	}

 
	@Override
	public Author updateFirstNameById(Integer authorId, Author author) {
		Optional<Author> optionalAuthor=authorRepository.findById(authorId);
		if(optionalAuthor.isPresent()) {
			Author author1=optionalAuthor.get();
			author1.setFirstName(author.getFirstName());
			authorRepository.save(author1);
			return author1;
		}
		throw new AuthorNotFoundException("Author not found with the authorId : "+authorId);
	}
 
	@Override
	public Author updateLastNameById(Integer authorId, Author author) {
		Optional<Author> optionalAuthor=authorRepository.findById(authorId);
		if(optionalAuthor.isPresent()) {
			Author author1=optionalAuthor.get();
			author1.setLastName(author.getLastName());
			authorRepository.save(author1);
			return author1;
		}
		throw new AuthorNotFoundException("Author not found with the authorId : "+authorId);
	}
 
	@Override
	public List<Book> getAllBooks(Integer authorId) {
		List<BookAuthor> bookAuthors=bookAuthorRepository.findAll();
		List<BookAuthor> bookAuthors1=new ArrayList<>();
		for(BookAuthor bookAuthor:bookAuthors) {
			if(bookAuthor.getAuthorId()==authorId) {
				bookAuthors1.add(bookAuthor);
			}
		}
		List<Book> booksByAuthor=new ArrayList<>();
		List<Book> books=bookRepository.findAll();
		for(Book book:books) {
			for(BookAuthor bookAuthor:bookAuthors1) {
				if(book.getIsbn()==bookAuthor.getIsbn()) {
					booksByAuthor.add(book);
				}
			}
		}
		if(booksByAuthor==null) {
			throw new AuthorNotFoundException("Books not found for the authorId : "+authorId);
		}
		return booksByAuthor;
	}

	@Override
	public List<Author> getAllAuthors() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();	}
}
