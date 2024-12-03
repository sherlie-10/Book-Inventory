package org.cap.bim.service;

import java.util.List;
import java.util.Optional;

import org.cap.bim.exception.BookNotFoundException;
import org.cap.bim.model.BookCondition;
import org.cap.bim.repository.IBookConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookConditionImpl implements IBookConditionService{



	@Autowired
	private IBookConditionRepository bookConditionRepository;

	@Override
	public BookCondition addNewBookCondition(BookCondition bookCondition)
	{
		return bookConditionRepository.save(bookCondition);
	}

	@Override
	public BookCondition getBookConditionByRank(Integer rank) {
		Optional<BookCondition> bookCondition=bookConditionRepository.findById(rank);
		
		if(bookCondition.isEmpty())
		{
			throw new BookNotFoundException("BookCondition Not Found with given ranks");
		}
		return bookCondition.get();
	}

	@Override
	public BookCondition updateDescriptionByRank(Integer rank,BookCondition bookCondition) {
		Optional<BookCondition> bookCondition1=bookConditionRepository.findById(rank);
		if(bookCondition1.isPresent())
		{
			BookCondition bookCondition2=bookCondition1.get();
			bookCondition2.setDescription(bookCondition.getDescription());
			bookConditionRepository.save(bookCondition2);
			return  bookCondition2;
		}
		throw new BookNotFoundException("Book Not found For Updation");

	}

	@Override
	public BookCondition updateFullDescriptionByRank(Integer rank,BookCondition bookCondition) {
		Optional<BookCondition> bookCondition1=bookConditionRepository.findById(rank);
		if(bookCondition1.isPresent())
		{
			BookCondition bookCondition2=bookCondition1.get();
			bookCondition2.setFullDescription(bookCondition.getFullDescription());
			bookConditionRepository.save(bookCondition2);
			return  bookCondition2;
		}
		throw new BookNotFoundException("Book Not found For Updation");
		
	}

	@Override
	public BookCondition updatePriceByRank(Integer rank,BookCondition bookCondition) {
		Optional<BookCondition> bookCondition1=bookConditionRepository.findById(rank);
		if(bookCondition1.isPresent())
		{
			BookCondition bookCondition2=bookCondition1.get();
			bookCondition2.setPrice(bookCondition.getPrice());
			bookConditionRepository.save(bookCondition2);
			return  bookCondition2;
		}
		throw new BookNotFoundException("Book Not found For Updation");

	}

	@Override
	public List<BookCondition> getAllBookConditionlist() 
	{
		List<BookCondition> bookConditions=bookConditionRepository.findAll();
		if(bookConditions!=null)
		{
			return bookConditions;
		}
		return null;
	}
	

}


