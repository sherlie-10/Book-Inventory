package org.cap.bim.repository;

import java.util.List;


import org.cap.bim.model.BookReview;
import org.cap.bim.model.BookReviewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookReviewRepository extends JpaRepository<BookReview, BookReviewId>{
	
	
	
	@Query("SELECT br FROM BookReview br WHERE br.book.isbn= ?1 ")
	List<BookReview> getBookReviewsByIsbn(String isbn);

}
