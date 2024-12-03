package org.cap.bim.controller;

import java.util.List;

import org.cap.bim.model.BookCondition;
import org.cap.bim.service.IBookConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/bookcondition")
@RestController
public class BookConditionController {
	
	@Autowired
	private IBookConditionService bookConditionService;
	
	@GetMapping
	public ResponseEntity<List<BookCondition>> GetAllBookCondtion()
	{
		List<BookCondition> bookCondition2=bookConditionService.getAllBookConditionlist();
		
		if(bookCondition2!=null)
		{
			return new ResponseEntity<List<BookCondition>>(bookCondition2, HttpStatus.OK);
		}
		return new ResponseEntity("Not Found",HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/{ranks}")
	public ResponseEntity<BookCondition> GetBookCondtion(@PathVariable("ranks")Integer ranks)
	{
		BookCondition bookCondition2=bookConditionService.getBookConditionByRank(ranks);
		
		if(bookCondition2!=null)
		{
			return new ResponseEntity<BookCondition>(bookCondition2, HttpStatus.OK);
		}
		return new ResponseEntity("Not Found",HttpStatus.BAD_REQUEST);
		
	}

	
	@PostMapping("/post")
	public ResponseEntity<BookCondition> createBook(@RequestBody BookCondition bookCondition)
	{
		BookCondition bookCondition2=bookConditionService.addNewBookCondition(bookCondition);
		
		if(bookCondition!=null)
		{
			return new ResponseEntity("BookCondition Added Successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity("BookCondition Object creation Error!",HttpStatus.BAD_REQUEST);
		
	}
	
	
	@PutMapping("/update/description/{ranks}")
	public ResponseEntity<BookCondition> updateDescriptionByRank(@PathVariable("ranks") Integer ranks, @RequestBody BookCondition bookCondition) {
	    BookCondition updatedBookCondition = bookConditionService.updateDescriptionByRank(ranks, bookCondition);

	    if (updatedBookCondition == null) {
	        return new ResponseEntity("Sorry! BookCondition is not present", HttpStatus.NOT_FOUND);
	    }

	    return new ResponseEntity("BookCondition Description Updated Successfully", HttpStatus.OK);
	}
	
	
    @PutMapping("/update/fullDescription/{ranks}")
    public ResponseEntity<BookCondition> updateFullDescriptionByRank(@PathVariable("ranks") Integer ranks, @RequestBody BookCondition bookCondition) {
    BookCondition bookCondition2 = bookConditionService.updateFullDescriptionByRank(ranks, bookCondition);

    if (bookCondition2 == null) {
        return new ResponseEntity("Sorry! BookCondition is not present", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity("BookCondition FullDescription Update Successfully", HttpStatus.OK);
    }
    
}

