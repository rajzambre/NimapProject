package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.model.Product;
import com.repository.ProductRepository;

@Service
public class ProductServices
{

	@Autowired
	private ProductRepository  productRepository;
	
	public Page<Product> getAllProducts(int page,int size)
	{
		return productRepository.findAll(PageRequest.of(page, size));
	}
	
	public Product getProductById(int id)
	{
			return productRepository.findById(id).orElse(null);
	}
	
	public Product createProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	public Product updateProduct(int id,Product product) 
	{
		if(productRepository.existsById(id))
		{
			product.setId(id);
			return productRepository.save(product);
		}
		return null;
	}
	
	public void deleteProduct(int id)
	{
		productRepository.deleteById(id);
	}
}
