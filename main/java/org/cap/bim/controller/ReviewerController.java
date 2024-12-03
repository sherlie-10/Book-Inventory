package org.cap.bim.controller;
import java.util.List;

import org.cap.bim.model.Reviewer;
import org.cap.bim.model.ReviewerDto;
import org.cap.bim.model.State;
import org.cap.bim.service.IReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReviewerController {

    @Autowired
    private IReviewerService reviewerService;

    @PostMapping("/reviewer/post")
    	public ResponseEntity<Reviewer> createReviewer(@RequestBody ReviewerDto reviewerDto)
    	{
    			Reviewer reviewer=new Reviewer();
    			reviewer.setReviewerid(reviewerDto.getReviewerid());
    			reviewer.setName(reviewerDto.getName());
    			reviewer.setEmployedBy(reviewerDto.getEmployedBy());
    	
    	Reviewer reviewer1=reviewerService.addReviewer(reviewer);
    		
    		if(reviewer1!=null)
    		{
    			return new ResponseEntity("reviewer Added Successfully", HttpStatus.CREATED);
    		}
    		return new ResponseEntity("reviewer creation Error!",HttpStatus.BAD_REQUEST);
    		
    	}
    
    @GetMapping("/reviewer/{reviewerId}")
		public ResponseEntity<Reviewer> findReviewer(@PathVariable ("reviewerId") Integer reviewerId)
    	{
		Reviewer reviewer=reviewerService.getReviewerById(reviewerId);
		
		if(reviewer!=null)
		
		{
			return new ResponseEntity<Reviewer>(reviewer, HttpStatus.OK);
		}
		return new ResponseEntity("Reviewer Id : "+reviewerId+" is not found!", HttpStatus.NOT_FOUND);
	}
    
    
    @GetMapping("/reviewer")
	public ResponseEntity<List<Reviewer>> getAllReviwers()
	{
	   List<Reviewer> reviewer=reviewerService.getAllReviwers();
	
	if(reviewer!=null)
	
	{
		return new ResponseEntity< List<Reviewer>>(reviewer, HttpStatus.OK);
	}
	return new ResponseEntity("Reviewer Id  is not found!", HttpStatus.NOT_FOUND);
}
    
   
    @PutMapping("/reviewer/name/{reviewerId}")
        public ResponseEntity<Reviewer> updateNameById(@PathVariable Integer reviewerId, @RequestBody ReviewerDto reviewerDto) 
    	{
        Reviewer reviewer1 = reviewerService.updateNameById(reviewerId, reviewerDto);
        
        if(reviewer1!=null)
        {
        	return new ResponseEntity<Reviewer>(reviewer1, HttpStatus.OK);
        }
        return new ResponseEntity("Reviewer Id : "+reviewerId+" is not found!", HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/reviewer/employedby/{reviewerId}")
    
    	public ResponseEntity<Reviewer> updateEmployedBy(@PathVariable Integer reviewerId, @RequestBody ReviewerDto reviewerDto) 
    {
    	
    	Reviewer reviewer2 = reviewerService.updateEmployedBy(reviewerId, reviewerDto);
    
    	if(reviewer2!=null)
    {
    	return new ResponseEntity<Reviewer>(reviewer2, HttpStatus.OK);
    }
    return new ResponseEntity("Reviewer Id : "+reviewerId+" is not found!", HttpStatus.NOT_FOUND);
    }
    
}

