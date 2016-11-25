package com.equipme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equipme.model.Customer;
import com.equipme.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer create(Customer customer) {

		Customer existing = customerRepository.findByEmail(customer.getEmail());
		if (existing != null) {
			return null;
		}
		// Handle Exception
		return customerRepository.create(customer);
	}

	@Override
	public List<Customer> findAll() {

		List<Customer> customers = customerRepository.findAll();
		if (customers == null) {
			return null;
		}
		return customers;
	}

	@Override
	public Customer update(String id, Customer customer) {
		Customer existing = customerRepository.findById(id);
		if (existing == null) {
			return null;
		}

		return customerRepository.update(customer);
	}

	@Override
	public void delete(String id) {

		Customer existing = customerRepository.findById(id);
		if (existing == null) {
			// Handle Exception
		}

		customerRepository.delete(existing);

	}

	@Override
	public Customer findById(String id) {

		Customer customer = customerRepository.findById(id);
		if (customer == null) {
			return null;
		}

		return customer;
	}

	@Override
	public Customer findByEmail(String email) {

		Customer existing = customerRepository.findByEmail(email);

		if (existing == null) {
			return null;
		}

		return existing;
	}

}
