package com.equipme.test.repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.equipme.model.Product;
import com.equipme.repository.ProductRepositoryImpl;
import com.equipme.repository.ProductRespository;
import com.equipme.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ProductRepositoryTest {

	// Dependency for the testing class
	@Mock
	private EntityManager em;

	@Mock
	private TypedQuery<Product> products;

	private Product product;

	// Respective class you are testing
	@InjectMocks
	private ProductRespository repository = new ProductRepositoryImpl();

	@Before
	public void setUp() {
		// Creates and Initializes the mocks
		MockitoAnnotations.initMocks(this);
		product = new Product();
		product.setId(UUID.randomUUID().toString());
		product.setProductName("Gold");
		product.setProductCategory("GOLDEN");
		product.setSkuCode("PS1233");

	}

	@Test
	public void testFindAll() {
		// Expected result
		List<Product> expected = Arrays.asList(product);
		Mockito.when(em.createNamedQuery("Product.findAllProducts", Product.class)).thenReturn(products);
		Mockito.when(products.getResultList()).thenReturn(expected);

		// Actual result
		List<Product> actual = repository.findAll();

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFindById() {
		Mockito.when(em.find(Product.class, product.getId())).thenReturn(product);
		Product actual = repository.findById(product.getId());
		Assert.assertEquals(product, actual);

	}

	@Test
	public void testFindBySkuCode() {
		List<Product> expected = Arrays.asList(product);
		Mockito.when(em.createNamedQuery("Product.findBySkuCode", Product.class)).thenReturn(products);
		Mockito.when(products.getResultList()).thenReturn(expected);

		// Product actual = repository.findBySkuCode(product.getSkuCode());
		// Assert.assertEquals(expected, actual);
	}

}