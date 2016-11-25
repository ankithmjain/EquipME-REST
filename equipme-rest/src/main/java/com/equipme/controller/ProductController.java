package com.equipme.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equipme.model.Product;
import com.equipme.service.ProductService;

@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findAll() {
		return service.findAll();
	}

	// For multiple parameter like value="/{id}/{city}" you can write like
	// @PathVariable("id") String id, @PathVariable("city") String City

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product findById(@PathVariable("id") String productId) {
		return service.findById(productId);
	}

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		String productsent = product.toString();
		System.out.println(productsent);
		return service.create(product);
	}

	@RequestMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.PUT)
	public Product update(@PathVariable("id") String id, @RequestBody Product product) {
		return service.update(id, product);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}

}
