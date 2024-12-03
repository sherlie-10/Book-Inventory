package org.cap.bim.service;

import java.util.List;

import org.cap.bim.model.BookCondition;

public interface IBookConditionService {
	
	public BookCondition addNewBookCondition(BookCondition bookCondition);
	public BookCondition getBookConditionByRank(Integer rank);
	public BookCondition updateDescriptionByRank(Integer rank,BookCondition bookCondition);
	public BookCondition updateFullDescriptionByRank(Integer rank,BookCondition bookCondition);
	public BookCondition updatePriceByRank(Integer rank,BookCondition bookCondition);
	
	public List<BookCondition> getAllBookConditionlist();


	


}
