package org.cap.bim.controller;


import java.util.List;

import org.cap.bim.model.Author;
import org.cap.bim.model.Book;
import org.cap.bim.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/author")
@RestController
public class AuthorController 
{
	@Autowired  
	private IAuthorService authorService;
	
	@PostMapping("/post")
	public ResponseEntity<String> addAuthor(@RequestBody Author author){
		Author author1=authorService.addAuthor(author);
		if(author1!=null) {
			return new ResponseEntity<String>("Author added successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Author creation Error!",HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/authors")
	public ResponseEntity<List<Author>> getAllAuthor(){
		List<Author> authors=authorService.getAllAuthors();
		if(authors==null) {
			return new ResponseEntity("Sorry! No author is available in the DB!",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Author>>(authors,HttpStatus.OK);
	}
	
	@GetMapping("{authorId}")
	public ResponseEntity<Author> getAuthorById(@PathVariable ("authorId") Integer authorId){
		Author author=authorService.getAuthorById(authorId);
		if(author!=null) {
			return new ResponseEntity<Author>(author, HttpStatus.OK);
		}
		return new ResponseEntity("Author with Id : "+authorId+" not found!",
				HttpStatus.NOT_FOUND);
	}
	@GetMapping("/firstname/{firstname}")
	public ResponseEntity<List<Author>> getAuthorByFirstName(@PathVariable ("firstname") String firstName){
		List<Author> author=authorService.getAuthorByFirstName(firstName);
		if(author!=null) {
			return new ResponseEntity<List<Author>>(author, HttpStatus.OK);
		}
		return new ResponseEntity("Author with the firstname : "+firstName+" not found!",
				HttpStatus.NOT_FOUND);
	}
	@GetMapping("/lastname/{lastname}")
	public ResponseEntity<List<Author>> getAuthorByLastName(@PathVariable ("lastname") String lastName){
		List<Author> author=authorService.getAuthorByLastName(lastName);
		if(author!=null) {
			return new ResponseEntity<List<Author>>(author, HttpStatus.OK);
		}
		return new ResponseEntity("Author with the lastname : "+lastName+" not found!",
				HttpStatus.NOT_FOUND);
	}
	@PutMapping("/update/firstname/{authorId}")
	public ResponseEntity<Author> updateFirstNameById(@PathVariable ("authorId") Integer authorId,@RequestBody Author author){
		Author author1=authorService.updateFirstNameById(authorId, author);
		if(author1==null) {
			return new ResponseEntity("Author with authorId : "+authorId+" not found!",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Author>(author1, HttpStatus.OK);
	}
	@PutMapping("/update/lastname/{authorId}")
	public ResponseEntity<Author> updateLastNameById(@PathVariable ("authorId") Integer authorId,@RequestBody Author author){
		Author author1=authorService.updateLastNameById(authorId, author);
		if(author1==null) {
			return new ResponseEntity("Author with authorId : "+authorId+" not found!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Author>(author1, HttpStatus.OK);
	}
	@GetMapping("/books/{authorId}")
	public ResponseEntity<List<Book>> getAllBooks(@PathVariable ("authorId") Integer authorId){
		List<Book> books=authorService.getAllBooks(authorId);
		if(books==null) 
		{
			return new ResponseEntity("Sorry! No books available for the authorId : "+authorId,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
}