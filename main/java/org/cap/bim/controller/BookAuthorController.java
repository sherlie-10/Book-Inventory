package org.cap.bim.controller;

import java.util.List;

import org.cap.bim.model.BookAuthor;
import org.cap.bim.service.IBookAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/bookauthor")
@RestController
public class BookAuthorController {
	
	
	@Autowired
	private IBookAuthorService bookAuthorService;
	
	@PostMapping("/post")
	public ResponseEntity<String> addAuthor(@RequestBody BookAuthor bookAuthor){
		BookAuthor bookAuthor1=bookAuthorService.addBookAuthor(bookAuthor);
		if(bookAuthor1!=null) {
			return new ResponseEntity<String>("BookAuthor added successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("BookAuthor creation Error!",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/authors")
	public ResponseEntity<List<BookAuthor>> getAllBookAuthors(){
		List<BookAuthor> bookAuthor1=bookAuthorService.getAllBookAuthors();
		if(bookAuthor1!=null) {
			return new ResponseEntity<List<BookAuthor>>(bookAuthor1, HttpStatus.OK);
		}
		return new ResponseEntity("BookAuthor creation Error!",HttpStatus.BAD_REQUEST);
	}
	

}
