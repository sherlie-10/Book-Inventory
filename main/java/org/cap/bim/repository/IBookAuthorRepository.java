package org.cap.bim.repository;

import org.cap.bim.model.BookAuthor;
import org.cap.bim.model.BookAuthorId;
import org.cap.bim.model.BookCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorId>{

}
