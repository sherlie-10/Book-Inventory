package org.cap.bim.service;

import java.util.List;

import org.cap.bim.model.Publisher;
import org.cap.bim.model.State;

public interface IPublisherService {
	
	public Publisher createPublisher(Publisher publisher);
	public List<Publisher> getAllPublishers();
	public Publisher getPublisherById(Integer publisherId);
	public Publisher getPublisherByName(String name);
	public List<Publisher> getPublisherByCity(String city);
	public List<Publisher> getPublisherByStateCode(State stateCode);
	
	public Publisher updatePublisherNameById(Integer publisherId,Publisher publisher);
	public Publisher updatePublisherCityById(Integer publisherId,Publisher publisher);
	public Publisher updatePublisherStateByState(Integer publisherId,State state);

	
	

	



	

}
