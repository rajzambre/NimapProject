package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.model.Category;
import com.repository.CategoryRepository;

@Service
public class CategoryServices
{

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Page<Category> getAllCategories(int page,int size)
	{
		return categoryRepository.findAll(PageRequest.of(page, size));
		
	}
	
	public Category getCategoryById(int id) 
	{
		return categoryRepository.findById(id).orElse(null); 	
	}
	
	public Category createCategory(Category category)
	{
	   return categoryRepository.save(category);	
	}
	
	public Category updateCategory(int id,Category category)
	{
		if(categoryRepository.existsById(id)) 
		{
			category.setId(id);
			return categoryRepository.save(category);
		}
		return null;
	}
	
	public void deleteCategory(int id) 
	{
	    categoryRepository.deleteById(id);
    }
}
