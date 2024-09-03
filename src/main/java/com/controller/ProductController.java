package com.controller;
import com.model.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.model.Category;
import com.model.Product;
import com.services.CategoryServices;
import com.services.ProductServices;

@RestController
@RequestMapping("/add_product")
public class ProductController 
{
	@Autowired
	private ProductServices ps;
	
	/*@Autowired
	private CategoryServices cs;*/
	
	@GetMapping
	public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10")int size)
	{
		return ps.getAllProducts(page, size);
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id)
	{
		return ps.getProductById(id);
	}
	
	@PostMapping()
	public Product createProduct(@RequestBody Product p)
	{
	
		
		return ps.createProduct(p);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable int id,@RequestBody Product p)
	{
		return ps.updateProduct(id, p);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable int id)
	{
		 ps.deleteProduct(id);
	}
	
	
}
