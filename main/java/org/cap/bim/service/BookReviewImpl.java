package org.cap.bim.service;

import java.util.ArrayList;

import java.util.List;

import org.cap.bim.exception.InventoryNotFoundException;
import org.cap.bim.model.BookReview;
import org.cap.bim.model.BookReviewDto;
import org.cap.bim.model.Reviewer;
import org.cap.bim.repository.IBookReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookReviewImpl implements IBookReviewService
{

	@Autowired
	private IBookReviewRepository bookReviewRepository; 
	
	@Override
	public BookReview addBookReview(BookReview bookReview)
	
	{
//		if(bookReview.getIsbn()==null || bookReview.getIsbnn  ().isEmpty() || bookReview.getReviewerId()<0)

		return bookReviewRepository.save(bookReview);
	}

	@Override
	public List<BookReview> getBookReviewByIsn(String isbn) 
	{
		List<BookReview> bookReviews=bookReviewRepository.getBookReviewsByIsbn(isbn);
	
		if(bookReviews.isEmpty())
		{
		throw new InventoryNotFoundException("Book Reviews DB is Empty");

			
		}
		return bookReviews;
		
		
	}

	@Override
	public List<BookReview> updateBookReviewRating(String isbn,BookReviewDto bookReviewDto) 
	{
		List<BookReview> bookReviews=bookReviewRepository.getBookReviewsByIsbn(isbn);
		if(bookReviews!=null)
		{
			for (BookReview bookReview : bookReviews) 
			{
				bookReview.setRating(bookReviewDto.getRating());
				bookReviewRepository.save(bookReview);
				
			}
			return bookReviews;
		}
		throw new InventoryNotFoundException("No Book Found With this given isbn");
	}

	@Override
	public List<BookReview> updateBookReviewCommnets(String isbn,BookReviewDto bookReviewDto) 
	{
		List<BookReview> bookReviews=bookReviewRepository.getBookReviewsByIsbn(isbn);
		if(bookReviews!=null)
		{
			for (BookReview bookReview : bookReviews) 
			{
				bookReview.setComments(bookReviewDto.getComments());
				bookReviewRepository.save(bookReview);
				
			}
			return bookReviews;
		}
		throw new InventoryNotFoundException("No Book Found With this given isbn");
	}
	

}
