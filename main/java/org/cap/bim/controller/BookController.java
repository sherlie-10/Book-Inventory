package org.cap.bim.controller;

import java.util.List;
import org.cap.bim.model.Book;
import org.cap.bim.model.BookDto;
import org.cap.bim.service.IBookService;
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
@RequestMapping("/api")
@RestController
public class BookController 
{
	@Autowired
	private IBookService bookService;
	
	
	@PostMapping("/book/post")
	public ResponseEntity<Book> createBook(@RequestBody BookDto bookdto)
	{
		Book book=new Book();
		book.setIsbn(bookdto.getIsbn());
		book.setTitle(bookdto.getTitle());
		book.setDescription(bookdto.getDescription());
		book.setEdition(bookdto.getEdition());
		book.setCatId(bookdto.getCatId());
		book.setPublisherId(bookdto.getPublisherId());
		Book book1=bookService.createbookData(book);
		
		if(book1!=null)
		{
			return new ResponseEntity("Book Added Successfully", HttpStatus.OK);
		}
		return new ResponseEntity("Book Object creation Error!",HttpStatus.BAD_REQUEST);
		
	}
	
	
	

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks()
	{ 
		List<Book> books= bookService.getAllBooks();
		if(books!=null)
		{
			return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
		}
		return new ResponseEntity("Book Object creation Error",HttpStatus.BAD_REQUEST);
	}
	

	@GetMapping("/book/{isbn}")
	public ResponseEntity<Book> findBookById(@PathVariable("isbn")String isbn){
		Book book=bookService.getBookByIsbn(isbn);
		
		if(book==null) {
			return new ResponseEntity("Sorry! book is not present:" + isbn+" Not Found!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);

	}
	
	@GetMapping("/bookdetails/{isbn}")
	public ResponseEntity<List<Object[]>> getBookDetails(@PathVariable("isbn")String isbn){
		List<Object[]> bookDetails=bookService.getBookDetails(isbn);
		
		if(bookDetails==null) {
			return new ResponseEntity("Sorry! book is not present:" + isbn+" Not Found!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object[]>>(bookDetails, HttpStatus.OK);

	}
	
	@GetMapping("/book/title/{title}")
	public ResponseEntity<Book> findBookByTitle(@PathVariable("title") String title)
	{
		Book book=bookService.getBookByTitle(title);
		if(book==null) {
			return new ResponseEntity("Sorry! book is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/book/category/{category}")
	public ResponseEntity<List<Book>> getBooksBycategory(@PathVariable Integer category)
	{
		List<Book> books= bookService.getBooksByCategory(category);
		if(books!=null)
		{
			return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
		}
		return new ResponseEntity("Books Not found",HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/book/publisherid/{publisherId}")
	public ResponseEntity<List<Book>> getBooksByPublisherId(@PathVariable Integer publisherId)
	{
		List<Book> books= bookService.getBooksByPublisherId(publisherId);
		if(books!=null)
		{
			return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
		}
		return new ResponseEntity("Books Not found",HttpStatus.BAD_REQUEST);
	}
	
	
	@PutMapping("/book/update/title/{isbn}")
	public ResponseEntity<Book> updateBookByisbn(@PathVariable("isbn")String isbn,@RequestBody BookDto bookDto)
	{
		Book book=new Book();
		book.setTitle(bookDto.getTitle());

		Book book1=bookService.updateBookByisbn(isbn, book);
		if(book1==null) {
			return new ResponseEntity("Sorry! Book is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book1, HttpStatus.OK);

	}
	

	@PutMapping("/book/update/description/{isbn}")
	public ResponseEntity<Book> updateBookDescrition(@PathVariable("isbn")String isbn,@RequestBody BookDto bookdto){

		
		Book book=new Book();
		book.setDescription(bookdto.getDescription());
		
		Book book1=bookService.updateBookDescrition(isbn, book);
		if(book1==null) {
			return new ResponseEntity("Sorry! Book is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book1, HttpStatus.OK);

	}
	
	@PutMapping("/book/update/edition/{isbn}")
	public ResponseEntity<Book> updateBookedition(@PathVariable("isbn")String isbn,@RequestBody BookDto bookdto){

		Book book=new Book();
		book.setEdition(bookdto.getEdition());
		
		Book book1=bookService.updateBookedition(isbn, book);
		if(book1==null) {
			return new ResponseEntity("Sorry! Book is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book1, HttpStatus.OK);

	}
	
	@PutMapping("/book/update/category/{isbn}")
	public ResponseEntity<Book> updateBookcategory(@PathVariable("isbn")String isbn,@RequestBody BookDto bookdto){

		Book book=new Book();
		book.setCatId(bookdto.getCatId());
		Book book1=bookService.updateBookcategory(isbn, book);
		if(book1==null) {
			return new ResponseEntity("Sorry! Book is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book1, HttpStatus.OK);

	}
	
	@PutMapping("/book/update/publisher/{isbn}")
	public ResponseEntity<Book> udpdateBookPublisher(@PathVariable("isbn")String isbn,@RequestBody BookDto bookdtDto){

		Book book=new Book();
		book.setPublisherId(bookdtDto.getPublisherId());
		Book book1=bookService.udpdateBookPublisher(isbn, book);
		if(book1==null) 
			return new ResponseEntity("Sorry! Book is not present",
					HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Book>(book1, HttpStatus.OK);

	}

	
	
	
	
}
