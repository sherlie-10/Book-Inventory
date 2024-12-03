package org.cap.bim.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(StateNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleStateEmptyException(
			StateNotFoundException ex,WebRequest request)
	{
		
		ErrorDetails details=new ErrorDetails();
		details.setTimestamp(LocalDateTime.now().toString());
		details.setMessage(ex.getMessage());
		details.setDescription(request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		
		
	}
	
	
	@ExceptionHandler(InventoryNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleInventoryEmptyException(
			InventoryNotFoundException ex,WebRequest request)
	{
		
		ErrorDetails details=new ErrorDetails();
		details.setTimestamp(LocalDateTime.now().toString());
		details.setMessage(ex.getMessage());
		details.setDescription(request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleBookEmptyException(
			BookNotFoundException ex,WebRequest request)
	{
		
		ErrorDetails details=new ErrorDetails();
		details.setTimestamp(LocalDateTime.now().toString());
		details.setMessage(ex.getMessage());
		details.setDescription(request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		
		
	}
	
	
	@ExceptionHandler(BookConditionNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleBookConditionNotFoundException(
			BookConditionNotFoundException ex,WebRequest request)
	{
		
		ErrorDetails details=new ErrorDetails();
		details.setTimestamp(LocalDateTime.now().toString());
		details.setMessage(ex.getMessage());
		details.setDescription(request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		
		
	}
	
	
	
	
	
	

}
