package org.cap.bim.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.cap.bim.model.BookReview;
import org.cap.bim.model.BookReviewDto;
import org.cap.bim.repository.IBookReviewRepository;
import org.cap.bim.service.BookReviewImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

public class BookReviewTest 
{

	
	@Mock
	private IBookReviewRepository bookReviewRepository;
	
	
	@InjectMocks
	private BookReviewImpl bookReviewImpl;
	
	
	

	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	
	
	@Test
    public void testAddBookReview() {
        BookReview mockBookReview = new BookReview();

        when(bookReviewRepository.save(any())).thenReturn(mockBookReview);

        BookReview result = bookReviewImpl.addBookReview(mockBookReview);

        // Assertions
        assertEquals(mockBookReview, result);
        
       
    }
	
	
	
	
	
	 @Test
	    public void testUpdateBookReviewRating() {
	        String isbn = "123456789";
	        BookReviewDto bookReviewDto = new BookReviewDto();
	        bookReviewDto.setRating(4);

	        List<BookReview> existingBookReviews = Arrays.asList(new BookReview(), new BookReview());
	        when(bookReviewRepository.getBookReviewsByIsbn(isbn)).thenReturn(existingBookReviews);
	        when(bookReviewRepository.save(any())).thenReturn(new BookReview());

	        List<BookReview> updatedBookReviews = bookReviewImpl.updateBookReviewRating(isbn, bookReviewDto);

	        assertEquals(existingBookReviews, updatedBookReviews);
	        for (BookReview updatedReview : updatedBookReviews) {
	            assertEquals(bookReviewDto.getRating(), updatedReview.getRating());
	        }
	    }
	 
	 
	 @Test
	    public void testUpdateBookReviewComments() {
	        String isbn = "987654321";
	        BookReviewDto bookReviewDto = new BookReviewDto();
	        bookReviewDto.setComments("Updated comments");

	        List<BookReview> existingBookReviews = Arrays.asList(new BookReview(), new BookReview());
	        when(bookReviewRepository.getBookReviewsByIsbn(isbn)).thenReturn(existingBookReviews);
	        when(bookReviewRepository.save(any())).thenReturn(new BookReview());

	        List<BookReview> updatedBookReviews = bookReviewImpl.updateBookReviewCommnets(isbn, bookReviewDto);

	        assertEquals(existingBookReviews.size(), updatedBookReviews.size());
	        for (BookReview updatedReview : updatedBookReviews) {
	            assertEquals(bookReviewDto.getComments(), updatedReview.getComments());
	        }
	    }

	 
	 
	 
	 @Test
	    public void testGetBookReviewByIsn() {
	        String isbn = "123456789";
	        List<BookReview> mockBookReviews = Arrays.asList(new BookReview(), new BookReview());
	        
	        when(bookReviewRepository.getBookReviewsByIsbn(isbn)).thenReturn(mockBookReviews);

	        List<BookReview> result = bookReviewImpl.getBookReviewByIsn(isbn);

	        assertEquals(mockBookReviews, result);
	    }
	 
	 
	 
}
