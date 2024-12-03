package org.cap.bim.repository;

import org.cap.bim.model.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewerRepository extends JpaRepository<Reviewer, Integer>{

}
