package com.equipme.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.equipme.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Customer create(Customer customer) {

		em.persist(customer);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		TypedQuery<Customer> customers = em.createNamedQuery("Customer.findAll", Customer.class);

		return customers.getResultList();
	}

	@Override
	public Customer findById(String id) {
		Customer customer = em.find(Customer.class, id);

		return customer;
	}

	@Override
	public Customer update(Customer customer) {

		em.merge(customer);
		return customer;
	}

	@Override
	public void delete(Customer customer) {

		em.remove(customer);

	}

	@Override
	public Customer findByEmail(String email) {
		TypedQuery<Customer> query = em.createNamedQuery("Customer.findByEmail", Customer.class);
		query.setParameter("cEmail", email);

		List<Customer> customers = query.getResultList();
		if (customers != null && customers.size() == 1) {
			return customers.get(0);
		}

		// Handle Exception
		return null;
	}

}
