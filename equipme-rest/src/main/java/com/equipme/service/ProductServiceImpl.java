package com.equipme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equipme.model.Product;
import com.equipme.repository.ProductRespository;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRespository repository;

	@Override
	public Product create(Product product) {

		Product existing = repository.findBySkuCode(product.getSkuCode());
		if (existing != null) {
			// TODO handle exception
			return null;
		}

		return repository.create(product);
	}

	@Override
	public List<Product> findAll() {

		List<Product> products = repository.findAll();
		if (products == null) {
			return null;
		}

		return products;
	}

	@Override
	public Product findById(String id) {

		Product product = repository.findById(id);
		if (product == null) {

			return null;
		}
		return product;
	}

	@Override
	public Product findByCategory(String category) {

		Product productCategory = repository.findByCategory(category);
		if (productCategory == null) {
			// TODO Handle Exception
			return null;
		}

		return productCategory;
	}

	@Override
	public Product findByName(String name) {

		return null;
	}

	@Override
	public Product update(String id, Product product) {

		Product existing = repository.findById(id);

		if (existing == null) {

			return null;
		}

		return repository.update(product);
	}

	@Override
	public void delete(String productId) {

		Product existing = repository.findById(productId);

		if (existing == null) {
			// Handle Exception
		}

		repository.delete(existing);

	}

}
