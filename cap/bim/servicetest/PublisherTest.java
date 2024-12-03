package org.cap.bim.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.cap.bim.model.Publisher;
import org.cap.bim.model.State;
import org.cap.bim.repository.IPublisherRepository;
import org.cap.bim.repository.IStateRepository;
import org.cap.bim.service.PublisherImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PublisherTest
{
	
	
	
	@Mock
	private IPublisherRepository publisherRepository;
	
	@Mock
	private IStateRepository stateRepository;
	
	@InjectMocks
	private PublisherImpl publisherImpl;
	
	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	
	
	   @Test
	    void testCreatePublisher() {
	        // Arrange
	        Publisher inputPublisher = new Publisher();
	        inputPublisher.setStateCode("CA");  // Assuming "CA" is a valid state code for testing

	        State mockState = new State();
	        
	        when(stateRepository.findById("CA")).thenReturn(Optional.of(mockState));
	        
	        Publisher savedPublisher = new Publisher();  // You can customize this based on your requirements
	        when(publisherRepository.save(any())).thenReturn(savedPublisher);

	        // Act
	        Publisher result = publisherImpl.createPublisher(inputPublisher);

	        // Assert
	        assertEquals(savedPublisher, result);
	       
	   }
	   
	   
	   @Test
	    void testGetAllPublishers() {
	      
		   List<Publisher> expectedPublishers = List.of(
	                new Publisher(0, "1", "Publisher1", null, null, null),
	                new Publisher(0, "2", "Publisher2", null, null, null)
	        );	                

	        when(publisherRepository.findAll()).thenReturn(expectedPublishers);

	        
	        List<Publisher> result = publisherImpl.getAllPublishers();

	       
	        assertEquals(expectedPublishers.size(), result.size());
	      
	    }
	   
	   
	   
	   @Test
	    void testGetPublisherById() {
	        Integer publisherId = 1;
	        Publisher expectedPublisher = new Publisher(publisherId, "Publisher1", null, null, null, null);

	        when(publisherRepository.findById(publisherId)).thenReturn(Optional.of(expectedPublisher));

	        Publisher result = publisherImpl.getPublisherById(publisherId);

	        assertEquals(expectedPublisher, result);
	    }
	   
	   
	   @Test
	    public void testGetPublisherByName() {
	        // Test when the publisher is found
	        String publisherName = "ABC Publishers";
	        Publisher mockPublisher = new Publisher();
	        mockPublisher.setPublisherId(1000);
	        mockPublisher.setName(publisherName);

	        List<Publisher> mockPublishers = Arrays.asList(mockPublisher);

	        when(publisherRepository.findAll()).thenReturn(mockPublishers);

	        Publisher result = publisherImpl.getPublisherByName(publisherName);

	        assertNotNull(result, " Publisher should not be null");
	        assertEquals(mockPublisher, result);
	    }
	   
	   
	   
	   @Test
	    public void testGetPublisherByCity() {
	        // Test when publishers with the specified city are found
	        String city = "New York";
	        Publisher publisher1 = new Publisher();
	        publisher1.setPublisherId(100);
	        publisher1.setCity(city);

	        Publisher publisher2 = new Publisher();
	        publisher2.setPublisherId(1003);
	        publisher2.setCity(city);

	        List<Publisher> mockPublishers = Arrays.asList(publisher1, publisher2);

	        when(publisherRepository.findAll()).thenReturn(mockPublishers);

	        List<Publisher> result = publisherImpl.getPublisherByCity(city);

	        assertEquals(mockPublishers, result);
	    }
	   
	   @Test
	    public void testGetPublisherByStateCode() {
	        // Test when publishers with the specified state code are found
	        State stateCode = new State();
	        stateCode.setStateCode("NY");

	        Publisher publisher1 = new Publisher();
	        publisher1.setPublisherId(10);
	        publisher1.setStateCode("NY");

	        Publisher publisher2 = new Publisher();
	        publisher2.setPublisherId(2100);
	        publisher2.setStateCode("NY");

	        List<Publisher> mockPublishers = Arrays.asList(publisher1, publisher2);

	        when(publisherRepository.findAll()).thenReturn(mockPublishers);

	        List<Publisher> result = publisherImpl.getPublisherByStateCode(stateCode);

	        assertNotNull(result, "Returned list should not be null");
	        assertEquals(mockPublishers, result, "Returned list should contain the publishers with the specified state code");
	    }

	   
	   @Test
	    public void testUpdatePublisherNameById() {
	        // Test when the publisher is found
	        Integer publisherId = 1;
	        Publisher existingPublisher = new Publisher();
	        existingPublisher.setPublisherId(publisherId);
	        existingPublisher.setName("Old Publisher Name");

	        Publisher updatedPublisher = new Publisher();
	        updatedPublisher.setName("New Publisher Name");

	        when(publisherRepository.findById(publisherId)).thenReturn(Optional.of(existingPublisher));
	        when(publisherRepository.save(existingPublisher)).thenReturn(existingPublisher);

	        Publisher result = publisherImpl.updatePublisherNameById(publisherId, updatedPublisher);

	        assertEquals(updatedPublisher.getName(), result.getName(), "Name should be updated to the new value");
	    }
	   
	   
	   @Test
	    public void testUpdatePublisherCityById() {
	        Integer publisherId = 1;
	        Publisher existingPublisher = new Publisher();
	        existingPublisher.setPublisherId(publisherId);
	        existingPublisher.setCity("Old City");

	        Publisher updatedPublisher = new Publisher();
	        updatedPublisher.setCity("New City");

	        when(publisherRepository.findById(publisherId)).thenReturn(Optional.of(existingPublisher));
	        when(publisherRepository.save(Mockito.any(Publisher.class))).thenReturn(existingPublisher);

	        Publisher result = publisherImpl.updatePublisherCityById(publisherId, updatedPublisher);


	        assertEquals(updatedPublisher.getCity(), result.getCity(), "City should be updated to the new value");
	    }
	   
	   
	   

	    @Test
	    public void testUpdatePublisherStateByState() {
	        // Test when the publisher is found
	        Integer publisherId = 1;
	        Publisher existingPublisher = new Publisher();
	        existingPublisher.setPublisherId(publisherId);
	        existingPublisher.setStateCode("NY");

	        State newState = new State();
	        newState.setStateCode("CA");

	        // Mock repository behavior
	        when(publisherRepository.findById(publisherId)).thenReturn(Optional.of(existingPublisher));
	        when(stateRepository.findById(newState.getStateCode())).thenReturn(Optional.of(newState));
	        when(publisherRepository.save(Mockito.any(Publisher.class))).thenReturn(existingPublisher);

	        Publisher result = publisherImpl.updatePublisherStateByState(publisherId, newState);


	        assertEquals(newState.getStateCode(), result.getStateCode());
	    }
	   
	   
	   

}
