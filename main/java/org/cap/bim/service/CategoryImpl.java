package org.cap.bim.service;

import java.util.List;

import org.cap.bim.exception.BookNotFoundException;

import org.cap.bim.exception.CategoryNotFoundException;
import org.cap.bim.model.Category;
import org.cap.bim.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryImpl implements ICategoryService 
{
	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category)
	{
		return  categoryRepository.save(category);
			
	}

	@Override
	public Category getCategoryWithId(Integer catId)
	{
			Category category=categoryRepository.findById(catId).get();
			if(category==null) {
				//throw new CategoryNotFoundException("Category  Not Found with given Category Id");
			}
			return category;
		
	}  

	@Override
	public Category updateCatDescription(Integer catId,Category category1) 
	{  
		Category category=categoryRepository.findById(catId).get();
		System.out.println(category.getCatId());
		
		category.setCatDescription(category1.getCatDescription());
		System.out.println(category.getCatDescription());
		categoryRepository.save(category);
		
		return category;
		
	}
	
	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}
		
}
