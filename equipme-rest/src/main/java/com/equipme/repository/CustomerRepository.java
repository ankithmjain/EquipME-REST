package com.equipme.repository;

import java.util.List;

import com.equipme.model.Customer;

public interface CustomerRepository {

	public Customer create(Customer customer);

	public List<Customer> findAll();

	public Customer findById(String id);

	public Customer update(Customer customer);

	public void delete(Customer id);

	public Customer findByEmail(String email);

}
