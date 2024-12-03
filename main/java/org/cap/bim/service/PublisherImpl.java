package org.cap.bim.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.cap.bim.exception.InventoryNotFoundException;
import org.cap.bim.exception.StateNotFoundException;
import org.cap.bim.model.Publisher;
import org.cap.bim.model.State;
import org.cap.bim.repository.IPublisherRepository;
import org.cap.bim.repository.IStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherImpl implements IPublisherService 
{
	@Autowired
	private IPublisherRepository publisherRepository;
	
	@Autowired
	private IStateRepository stateRepository;

	@Override
	public Publisher createPublisher(Publisher publisher)
	{
				Optional<State> state=stateRepository.findById(publisher.getStateCode());
				if(state.isEmpty())
				{
					throw new StateNotFoundException("State is not found");
					
				}
		       publisher.setStateCode(publisher.getStateCode());
		       return publisherRepository.save(publisher);
	
	}

	@Override
	public List<Publisher> getAllPublishers() 
	{
		return publisherRepository.findAll();
	}

	@Override
	public Publisher getPublisherById(Integer publisherId) {
		
		Optional<Publisher> publisher=publisherRepository.findById(publisherId);
		if (publisher.isPresent()) 
		{
			return publisher.get();
		}
		throw new InventoryNotFoundException("publisherId is not present");
	}

	@Override
	public Publisher getPublisherByName(String name)
	{
		List<Publisher> publishers=publisherRepository.findAll();
		 Publisher foundPublisher = null;

		    for (Publisher publisher : publishers)
		    {
		        if (publisher.getName().equals(name)) 
		        {
		            foundPublisher = publisher;
		            break;  
		        }
		    }

		    if (foundPublisher == null)
		    {
		        throw new InventoryNotFoundException("Publisher not found with name: " + name);
		    }

		    return foundPublisher;
	}

	@Override
	public List<Publisher> getPublisherByCity(String city) 
	{
		List<Publisher> publishers=publisherRepository.findAll();
		List<Publisher> foundpublishers=new ArrayList<>();

			if(publishers!=null)
			{
				    for (Publisher publisher : publishers)
				    {
				        if (publisher.getCity().equals(city)) 
				        {
				        	foundpublishers.add(publisher);
				        }
				    }
			}

		    if (foundpublishers.isEmpty())
		    {
		        throw new InventoryNotFoundException("Publishers are  not found with city: " + city);
		    }

		    return foundpublishers;
		
	}

	@Override
	public List<Publisher> getPublisherByStateCode(State stateCode) 
	{
		
		List<Publisher> publishers=publisherRepository.findAll();
		List<Publisher> foundpublishers=new ArrayList<>();

			if(publishers!=null)
			{	
			    for (Publisher publisher : publishers)
			    {
			        if (publisher.getStateCode().equals(stateCode.getStateCode())) 
			        {
			        	foundpublishers.add(publisher);
			        }
			    }
			} 	
		    if (foundpublishers.isEmpty())
		    {
		        throw new InventoryNotFoundException("Publishers are not found with stateCode: " + stateCode);
		    }

		    return foundpublishers;
	}

	@Override
	public Publisher updatePublisherNameById(Integer publisherId, Publisher publisher) {
	    Optional<Publisher> optionalPublisher = publisherRepository.findById(publisherId);

	    if (optionalPublisher.isPresent()) {
	        Publisher publisher1 = optionalPublisher.get();
	        publisher1.setName(publisher.getName());
	        publisherRepository.save(publisher1);
	        return publisher1;
	    } else 
	    {
	        throw new InventoryNotFoundException("Publisher with ID " + publisherId + " not found");
	    }
	}

	
	@Override
	public Publisher updatePublisherCityById(Integer publisherId, Publisher publisher) {
	    Optional<Publisher> optionalPublisher = publisherRepository.findById(publisherId);

	    if (optionalPublisher.isPresent()) {
	        Publisher publisher1 = optionalPublisher.get();
	        publisher1.setCity(publisher.getCity());
	        publisherRepository.save(publisher1);
	        return publisher1;
	    } else {
	        throw new InventoryNotFoundException("Publisher with ID " + publisherId + "is  not found");
	    }
	}
	


	
	@Override
	public Publisher updatePublisherStateByState(Integer publisherId,State state) 
	{
	    Optional<Publisher> optionalPublisher = publisherRepository.findById(publisherId);
	    State state1  =stateRepository.findById(state.getStateCode()).get();	

	    if (optionalPublisher.isPresent()) 
	    {
	        Publisher publisher1 = optionalPublisher.get();
	        publisher1.setStateCode(state1.getStateCode());
	        publisherRepository.save(publisher1);
	        return publisher1;
	        
	    }
	    else
	    {
	        throw new InventoryNotFoundException("Publisher with ID " + publisherId + "is  not found");
	    }
		
		
	}
	
}
