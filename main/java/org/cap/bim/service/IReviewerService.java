package org.cap.bim.service;
import java.util.List;

import org.cap.bim.model.Reviewer;
import org.cap.bim.model.ReviewerDto;

public interface IReviewerService {

		public Reviewer addReviewer(Reviewer reviewer);

		public Reviewer getReviewerById(Integer reviewerId);

		public Reviewer updateNameById(Integer reviewerId, ReviewerDto reviewer);

		public Reviewer updateEmployedBy(Integer reviewerId, ReviewerDto reviewerDto);
		
		public List<Reviewer> getAllReviwers();


	}


