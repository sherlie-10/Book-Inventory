package org.cap.bim.service;

import java.util.List;

import org.cap.bim.model.BookReview;
import org.cap.bim.model.BookReviewDto;

public interface IBookReviewService
{
    public BookReview addBookReview(BookReview bookReview);
	
	public List<BookReview>  getBookReviewByIsn(String isbn);
	
	public List<BookReview > updateBookReviewRating(String isbn,BookReviewDto bookReviewDto);
	
	public List< BookReview> updateBookReviewCommnets(String isbn,BookReviewDto bookReviewDto);
 

}
