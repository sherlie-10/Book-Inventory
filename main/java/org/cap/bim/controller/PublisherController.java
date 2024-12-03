package org.cap.bim.controller;

import java.util.List;


import org.cap.bim.model.Inventory;
import org.cap.bim.model.Publisher;
import org.cap.bim.model.PublisherDto;
import org.cap.bim.model.State;
import org.cap.bim.model.StateDto;
import org.cap.bim.service.IPublisherService;
import org.hibernate.annotations.Parameter;
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
@RequestMapping("/api/publisher")
@RestController
public class PublisherController {
	
	@Autowired
	private IPublisherService publisherService;
	
	@PostMapping("/post")
	public ResponseEntity<Publisher> createState(@RequestBody PublisherDto publisherdto)
	
	{
		Publisher publisher=new Publisher();
		publisher.setPublisherId(publisherdto.getPublisherId());
		publisher.setName(publisherdto.getName());
		publisher.setCity(publisherdto.getCity());
		publisher.setStateCode(publisherdto.getStateCode());
		
		Publisher publisher1=publisherService.createPublisher(publisher);
	
		if (publisher1!=null)
		{
			System.out.println("hii");
			return new ResponseEntity("publisher1added successfully", HttpStatus.CREATED);

		}
		return new ResponseEntity("publisher1 Object creation Error!",
				HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/publishers")
	public ResponseEntity<List<Publisher>> getAllPublishers()
	{
		List<Publisher> publishers=publisherService.getAllPublishers();
		if(publishers.isEmpty())
			return new ResponseEntity("Sorry! publishers DB is empty!", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<Publisher>>(publishers, HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Publisher> getPublisherByname(@PathVariable("name")String name )
	{
		Publisher publisher=publisherService.getPublisherByName(name);
		if(publisher==null) {
			return new ResponseEntity("Sorry! Publisher is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Publisher>(publisher, HttpStatus.OK);
		
	
		
	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<List<Publisher>> getPublisherBycity(@PathVariable("city")String city )
	{
		List<Publisher> publisher=publisherService.getPublisherByCity(city);
		if(publisher==null) {
			return new ResponseEntity("Sorry! Publisher is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Publisher>>(publisher, HttpStatus.OK);
		
	
		
	}
	
	@GetMapping("/state/{state}")
	public ResponseEntity<List<Publisher>> getPublisherBystate(@PathVariable("state")State state )
	{
		List<Publisher> publisher=publisherService.getPublisherByStateCode(state);
		if(publisher==null) {
			return new ResponseEntity("Sorry! Publisher is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Publisher>>(publisher, HttpStatus.OK);
		
	
		
	}
	
	
	@PutMapping("/update/name/{publisherId}")
	public ResponseEntity<Publisher> updatePublisherNameById(@PathVariable("publisherId")Integer publisherId,@RequestBody PublisherDto publisherDto)
	{
		Publisher publisher=new Publisher();
		publisher.setName(publisherDto.getName());
		
		Publisher publisher1=publisherService.updatePublisherNameById(publisherId,publisher);
		
		if(publisher1==null) {
			return new ResponseEntity("Sorry! publisherId is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Publisher>(publisher1, HttpStatus.OK);

	}
	
	@PutMapping("/update/city/{publisherId}")
	public ResponseEntity<Publisher> updatePublisherCityById(@PathVariable("publisherId")Integer publisherId,@RequestBody PublisherDto publisherDto)
	{
		Publisher publisher=new Publisher();
		publisher.setCity(publisherDto.getCity());
		Publisher publisher1=publisherService.updatePublisherCityById(publisherId,publisher);
		
		if(publisher1==null) {
			return new ResponseEntity("Sorry! publisherId is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Publisher>(publisher1, HttpStatus.OK);

	}
	
	
	@PutMapping("/update/state/{publisherId}")
	public ResponseEntity<Publisher> updatePublisherStateByState(@PathVariable("publisherId")Integer publisherId,@RequestBody StateDto stateDto)
	{
		State state=new State();
		state.setStateCode(stateDto.getStateCode());

		Publisher publisher1=publisherService.updatePublisherStateByState(publisherId,state);
		
		if(publisher1==null)
		{
			return new ResponseEntity("Sorry! publisherId is not present",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Publisher>(publisher1, HttpStatus.OK);

	}
	

}
