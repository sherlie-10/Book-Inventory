package org.cap.bim.repository;


import java.util.List;

import org.cap.bim.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
	
	
	@Query("SELECT b.title AS bookTitle, a.firstName, a.lastName , br.rating AS reviewRating, br.comments AS reviewComments " +
            "FROM BookAuthor ba " +
            "JOIN ba.book b " +
            "JOIN ba.author a " +
            "LEFT JOIN BookReview br ON b.isbn = br.isbn " +
            "WHERE b.isbn = :isbn")
    List<Object[]> findBookDetailsByIsbn( String isbn);

}
