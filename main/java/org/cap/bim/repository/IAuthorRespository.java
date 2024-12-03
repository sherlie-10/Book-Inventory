package org.cap.bim.repository;

import org.cap.bim.model.Author;
import org.cap.bim.model.Book;
import org.cap.bim.model.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRespository extends JpaRepository<Author, Integer> {

}
