package com.equipme.service;

import java.util.List;

import com.equipme.model.Customer;

public interface CustomerService {

	public Customer create(Customer customer);

	public List<Customer> findAll();

	public Customer findById(String id);

	public Customer update(String id, Customer customer);

	public void delete(String productId);

	public Customer findByEmail(String email);

}
