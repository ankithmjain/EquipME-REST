package com.equipme.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.equipme.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRespository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Product> findAll() {

		TypedQuery<Product> products = em.createNamedQuery("Product.findAllProducts", Product.class);
		return products.getResultList();
	}

	@Override
	public Product findById(String id) {

		return em.find(Product.class, id);
	}

	@Override
	public Product findByName(String name) {

		return null;
	}

	@Override
	public Product create(Product product) {
		em.persist(product);
		return product;
	}

	@Override
	public Product update(Product product) {
		em.merge(product);

		return product;
	}

	@Override
	public void delete(Product product) {

		em.remove(product);

	}

	@Override
	public Product findByCategory(String category) {

		return em.find(Product.class, category);
	}

	@Override
	public Product findBySkuCode(String skuCode) {

		TypedQuery<Product> skuQuery = em.createNamedQuery("Product.findBySkuCode", Product.class);
		skuQuery.setParameter("skuCode", skuCode);

		List<Product> products = skuQuery.getResultList();
		if (products != null && products.size() == 1) {
			return products.get(0);
		}
		// TODO Handle Exception
		return null;
	}

}
