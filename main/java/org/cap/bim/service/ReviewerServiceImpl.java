package org.cap.bim.service;
import java.util.List;
import java.util.Optional;

import org.cap.bim.exception.ReviewerNotFoundException;
import org.cap.bim.model.Reviewer;
import org.cap.bim.model.ReviewerDto;
import org.cap.bim.repository.IReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewerServiceImpl implements IReviewerService{

	@Autowired
	private IReviewerRepository reviewerRepository;

	@Override
	public Reviewer addReviewer(Reviewer reviewer) {
		
	
	return reviewerRepository.save(reviewer);
	}
	
	@Override
	public Reviewer getReviewerById(Integer reviewerId) {
		Optional<Reviewer> reviewer=reviewerRepository.findById(reviewerId);
		if(reviewer.isPresent()) {
			return reviewer.get();
		}
		return null;
	}

	@Override
	public Reviewer updateNameById(Integer reviewerId, ReviewerDto reviewer) {
			 Optional<Reviewer> optionalReviewer=reviewerRepository.findById(reviewerId);
			 
				if(optionalReviewer.isPresent()) {
					Reviewer reviewer1=optionalReviewer.get();
					reviewer1.setName(reviewer.getName());
					reviewerRepository.save(reviewer1);
					return reviewer1;
				}
				throw new ReviewerNotFoundException("Reviewer with ID "+ reviewerId +" is not found");
	}
	

	@Override
	public Reviewer updateEmployedBy(Integer reviewerId, ReviewerDto reviewerDto) 
	{
		 Optional<Reviewer> optionalReviewer=reviewerRepository.findById(reviewerId);
		 if(optionalReviewer.isPresent()) {
				Reviewer reviewer2=optionalReviewer.get();
				reviewer2.setEmployedBy(reviewerDto.getEmployedBy());
				reviewerRepository.save(reviewer2);
				return reviewer2;
			}
			throw new ReviewerNotFoundException("Reviewer with ID "+ reviewerId +" is not found");
		 
		
	}

	@Override
	public List<Reviewer> getAllReviwers() {
		return reviewerRepository.findAll();
	}

}