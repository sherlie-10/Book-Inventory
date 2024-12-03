package org.cap.bim.service;

import java.util.List;

import org.cap.bim.model.BookAuthor;
import org.springframework.stereotype.Repository;


public interface IBookAuthorService {
	public BookAuthor addBookAuthor(BookAuthor bookAuthor);
		public List<BookAuthor> getAllBookAuthors();

}
