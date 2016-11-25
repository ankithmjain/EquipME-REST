package com.equipme.service;

import java.util.List;

import com.equipme.model.Product;

public interface ProductService {

	public Product create(Product product);

	public List<Product> findAll();

	public Product findById(String id);

	public Product findByCategory(String category);

	public Product findByName(String name);

	public Product update(String id, Product product);

	public void delete(String productId);

}
