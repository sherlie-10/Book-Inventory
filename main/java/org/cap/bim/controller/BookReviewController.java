package org.cap.bim.controller;

import java.util.List;

import org.cap.bim.model.Book;
import org.cap.bim.model.BookReview;
import org.cap.bim.model.BookReviewDto;
import org.cap.bim.service.IBookReviewService;
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
@RequestMapping("/api/bookreview")
@RestController
public class BookReviewController
{
	@Autowired
	private IBookReviewService bookReviewService;
	
	
	
	@PostMapping("/post")
	public ResponseEntity<BookReview> createBook(@RequestBody BookReviewDto bookReviewDto)
	{
		BookReview bookReview=new BookReview();
		
		bookReview.setIsbn(bookReviewDto.getIsbn());
		bookReview.setComments(bookReviewDto.getComments());
		bookReview.setRating(bookReviewDto.getRating());
		bookReview.setReviewerId(bookReviewDto.getReviewerId());
		
		BookReview bookReview2=bookReviewService.addBookReview(bookReview);
		
		if(bookReview2!=null)
		{
			return new ResponseEntity("BookReview Added Successfully", HttpStatus.OK);
		}
		return new ResponseEntity("BookReview Object creation Error!",HttpStatus.BAD_REQUEST);
		
	}

	
	@GetMapping("/{isbn}")
	public ResponseEntity<List<BookReview>> findBookById(@PathVariable("isbn")String isbn){
		List<BookReview> bookReviews=bookReviewService.getBookReviewByIsn(isbn);
		
		if(bookReviews!=null) {
			return new ResponseEntity<List<BookReview>>(bookReviews,HttpStatus.OK);

			
		}
		return new ResponseEntity("Sorry! book is not present:" + isbn+" Not Found!",
				HttpStatus.NOT_FOUND);

	}
	
	@PutMapping("update/rating/{isbn}")
	public ResponseEntity<List<BookReview>> updateReviewRating(@RequestBody BookReviewDto bookReviewDto , @PathVariable("isbn")String isbn){
		List<BookReview> bookReviews=bookReviewService.updateBookReviewRating(isbn, bookReviewDto);
		
		if(bookReviews!=null) {
			return new ResponseEntity<List<BookReview>>(bookReviews,HttpStatus.OK);

			
		}
		return new ResponseEntity("Sorry! book is not present:" + isbn+" Not Found!",
				HttpStatus.NOT_FOUND);

	}
	
	@PutMapping("update/comments/{isbn}")
	public ResponseEntity<List<BookReview>> updateBookReviewCommnets(@RequestBody BookReviewDto bookReviewDto , @PathVariable("isbn")String isbn){
		List<BookReview> bookReviews=bookReviewService.updateBookReviewCommnets(isbn, bookReviewDto);
		
		if(bookReviews!=null) {
			return new ResponseEntity<List<BookReview>>(bookReviews,HttpStatus.OK);

			
		}
		return new ResponseEntity("Sorry! book is not present:" + isbn+" Not Found!",
				HttpStatus.NOT_FOUND);

	}
}
