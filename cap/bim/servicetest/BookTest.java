package org.cap.bim.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.cap.bim.model.Book;
import org.cap.bim.model.Category;
import org.cap.bim.model.Publisher;
import org.cap.bim.repository.BookRepository;
import org.cap.bim.repository.ICategoryRepository;
import org.cap.bim.repository.IPublisherRepository;
import org.cap.bim.service.BookImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BookTest
{
	
	@Mock
	private BookRepository bookRepository;
	
	@Mock
	private ICategoryRepository categoryRepository;
	
	
	@Mock
	private IPublisherRepository publisherRepository;
	
	@InjectMocks
	private BookImpl bookImpl;
	
	
	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	
	 @Test
	    public void testCreateBookData_Successful() {
	        // Arrange
	        Book inputBook = new Book();
	        inputBook.setIsbn("1234567890");

	        // Mocking behavior
	        when(bookRepository.save(any(Book.class))).thenReturn(inputBook);

	        // Act
	        Book result = bookImpl.createbookData(inputBook);

	        // Assert
	        assertEquals(inputBook.getIsbn(), result.getIsbn());

	        
	    }
	
	 @Test
	    public void testGetAllBooks_Successful() {
	        // Arrange
	        Book book1 = new Book();
	        Book book2 = new Book();
	        List<Book> mockBooks = Arrays.asList(book1, book2);

	        when(bookRepository.findAll()).thenReturn(mockBooks);

	        List<Book> result = bookImpl.getAllBooks();

	        assertEquals(2, result.size());

	    }


	 
	 

	    @Test
	    public void testGetBookByIsbn()
	    {
	        String isbn = "123456789";
	        Book mockBook = new Book();
	        mockBook.setIsbn(isbn);
	        mockBook.setTitle("Mock Book");

	        when(bookRepository.findById(isbn)).thenReturn(Optional.of(mockBook));

	        Book result = bookImpl.getBookByIsbn(isbn);


	        
	        assertEquals(mockBook, result);
	    }
	    
	    
	    @Test
	    public void testGetBookByTitle() {
	        // Prepare test data
	        String titleToFind = "Mock Book";
	        Book mockBook1 = new Book();
	        mockBook1.setIsbn("123456789");
	        mockBook1.setTitle("Mock Book");

	        Book mockBook2 = new Book();
	        mockBook2.setIsbn("987654321");
	        mockBook2.setTitle("Another Book");

	        List<Book> mockBooks = Arrays.asList(mockBook1, mockBook2);

	        when(bookRepository.findAll()).thenReturn(mockBooks);

	        Book result = bookImpl.getBookByTitle(titleToFind);


	       
	        assertEquals(mockBook1, result);

	    }
	    
	    

	    @Test
	    public void testGetBooksByCategory() {
	        // Prepare test data
	        Integer categoryToFind = 1;

	        Book mockBook1 = new Book();
	        mockBook1.setIsbn("123456789");
	        mockBook1.setTitle("Mock Book 1");
	        mockBook1.setCategory(new Category(1, "Category 1"));

	        Book mockBook2 = new Book();
	        mockBook2.setIsbn("987654321");
	        mockBook2.setTitle("Mock Book 2");
	        mockBook2.setCategory(new Category(2, "Category 2"));

	        List<Book> mockBooks = Arrays.asList(mockBook1, mockBook2);

	        when(bookRepository.findAll()).thenReturn(mockBooks);

	        List<Book> result = bookImpl.getBooksByCategory(categoryToFind);


	        assertEquals(mockBook1, result.get(0), "Returned list should contain the book with the specified category");

	       
	    }
	    
	    

	    @Test
	    public void testGetBooksByPublisherId() {
	        Integer publisherIdToFind = 1;

	        Publisher mockPublisher = new Publisher();
	        mockPublisher.setPublisherId(publisherIdToFind);

	        Book mockBook1 = new Book();
	        mockBook1.setIsbn("123456789");
	        mockBook1.setTitle("Mock Book 1");
	        mockBook1.setPublisher(mockPublisher);

	        Book mockBook2 = new Book();
	        mockBook2.setIsbn("987654321");
	        mockBook2.setTitle("Mock Book 2");
	        mockBook2.setPublisher(mockPublisher);

	        List<Book> mockBooks = Arrays.asList(mockBook1, mockBook2);

	        when(bookRepository.findAll()).thenReturn(mockBooks);

	        List<Book> result = bookImpl.getBooksByPublisherId(publisherIdToFind);

	      

	       
	        assertEquals(mockBooks, result, "Returned list should contain books with the specified publisherId");

	
	    }
	    
	    
	    @Test
	    public void testUpdateBookByIsbn() {
	        String isbnToUpdate = "123456789";

	        Book existingBook = new Book();
	        existingBook.setIsbn(isbnToUpdate);
	        existingBook.setTitle("Old Title");

	        Book updatedBook = new Book();
	        updatedBook.setIsbn(isbnToUpdate);
	        updatedBook.setTitle("New Title");

	        when(bookRepository.findById(isbnToUpdate)).thenReturn(Optional.of(existingBook));
	        when(bookRepository.save(existingBook)).thenReturn(existingBook);

	        Book result = bookImpl.updateBookByisbn(isbnToUpdate, updatedBook);

	       
	        assertNotNull(result, "Returned Book should not be null");
	        assertEquals(updatedBook.getTitle(), result.getTitle());
	    }

	    @Test
	    public void testUpdateBookDescription() {
	        String isbnToUpdate = "123456789";

	        Book existingBook = new Book();
	        existingBook.setIsbn(isbnToUpdate);
	        existingBook.setDescription("Old Description");

	        Book updatedBook = new Book();
	        updatedBook.setIsbn(isbnToUpdate);
	        updatedBook.setDescription("New Description");

	        when(bookRepository.findById(isbnToUpdate)).thenReturn(Optional.of(existingBook));
	        when(bookRepository.save(existingBook)).thenReturn(existingBook);

	        Book result = bookImpl.updateBookDescrition(isbnToUpdate, updatedBook);

	       

	        assertEquals(updatedBook.getDescription(), result.getDescription());
	    }
	    
	    
	    
	    @Test
	    public void testUpdateBookCategory() {
	        String isbnToUpdate = "123456789";
	        Integer categoryIdToUpdate = 1;

	        Category mockCategory = new Category();
	        mockCategory.setCatId(categoryIdToUpdate);

	        Book existingBook = new Book();
	        existingBook.setIsbn(isbnToUpdate);
	        existingBook.setCatId(categoryIdToUpdate);

	        Book updatedBook = new Book();
	        updatedBook.setIsbn(isbnToUpdate);
	        updatedBook.setCatId(categoryIdToUpdate);

	        when(categoryRepository.findById(categoryIdToUpdate)).thenReturn(Optional.of(mockCategory));
	        when(bookRepository.findById(isbnToUpdate)).thenReturn(Optional.of(existingBook));
	        when(bookRepository.save(existingBook)).thenReturn(existingBook);

	        Book result = bookImpl.updateBookcategory(isbnToUpdate, updatedBook);


	       
	        assertEquals(updatedBook.getCatId(), result.getCatId());
	    }
	    
	    
	    
	    
	    @Test
	    public void testUpdateBookEdition() {
	        // Prepare test data
	        String isbnToUpdate = "123456789";

	        Book existingBook = new Book();
	        existingBook.setIsbn(isbnToUpdate);
	        existingBook.setEdition('3');

	        Book updatedBook = new Book();
	        updatedBook.setIsbn(isbnToUpdate);
	        updatedBook.setEdition('4');

	        when(bookRepository.findById(isbnToUpdate)).thenReturn(Optional.of(existingBook));
	        when(bookRepository.save(existingBook)).thenReturn(existingBook);

	        Book result = bookImpl.updateBookedition(isbnToUpdate, updatedBook);


	        
	        assertEquals(updatedBook.getEdition(), result.getEdition());
	        		
	    }
	    
	    
	    @Test
	    public void testUpdateBookPublisher() {
	        String isbnToUpdate = "123456789";
	        Integer publisherIdToUpdate = 1;

	        Publisher mockPublisher = new Publisher();
	        mockPublisher.setPublisherId(publisherIdToUpdate);

	        Book existingBook = new Book();
	        existingBook.setIsbn(isbnToUpdate);
	        existingBook.setPublisherId(publisherIdToUpdate);

	        Book updatedBook = new Book();
	        updatedBook.setIsbn(isbnToUpdate);
	        updatedBook.setPublisherId(publisherIdToUpdate);

	        // Mock repository behavior
	        when(publisherRepository.findById(publisherIdToUpdate)).thenReturn(Optional.of(mockPublisher));
	        when(bookRepository.findById(isbnToUpdate)).thenReturn(Optional.of(existingBook));
	        when(bookRepository.save(existingBook)).thenReturn(existingBook);

	        Book result = bookImpl.udpdateBookPublisher(isbnToUpdate, updatedBook);

	      

	        assertNotNull(result, "Returned Book should not be null");
	        assertEquals(updatedBook.getPublisherId(), result.getPublisherId(), "PublisherId should be updated to the new value");
	    }

	   



}
