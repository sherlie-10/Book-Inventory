package org.cap.bim.repository;

import org.cap.bim.model.BookCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookConditionRepository extends JpaRepository<BookCondition, Integer>{

}
