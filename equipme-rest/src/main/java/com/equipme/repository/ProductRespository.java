package com.equipme.repository;

import java.util.List;

import com.equipme.model.Product;

public interface ProductRespository {

	public Product create(Product product);

	public List<Product> findAll();

	public Product findById(String id);

	public Product findByName(String name);

	public Product findByCategory(String category);

	public Product update(Product product);

	public void delete(Product id);

	public Product findBySkuCode(String skuCode);

}
