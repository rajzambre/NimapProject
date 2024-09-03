package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Category;
import com.services.CategoryServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/add_category")
public class CategoryController 
{
	@Autowired
	private CategoryServices categoryService;
	
	@GetMapping
	public Page<Category> getCategories(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10")int size)
	{
		return categoryService.getAllCategories(page, size);
		
	}
	
	@GetMapping("/{id}")
	public Category getCategoryByd(@PathVariable int id)
	{
	  return categoryService.getCategoryById(id);	
	}
	
	@PostMapping
	public Category createCategory(@RequestBody Category category)
	{
		return categoryService.createCategory(category);
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable int id,@RequestBody Category category) 
	{
		return categoryService.updateCategory(id, category);
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable int id)
	{
		categoryService.deleteCategory(id);
	}
	
}
