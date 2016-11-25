package com.equipme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equipme.model.Customer;
import com.equipme.service.CustomerService;

/**
 * The Class CustomerController.
 */
@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class CustomerController {

	/** The customer service. */
	@Autowired
	private CustomerService customerService;

	/**
	 * Creates the.
	 *
	 * @param customer
	 *            the customer
	 * @return the customer
	 */
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Customer create(@RequestBody Customer customer) {

		return customerService.create(customer);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	// For multiple parameter like value="/{id}/{city}" you can write like
	// @PathVariable("id") String id, @PathVariable("city") String City

	/**
	 * Find by id.
	 *
	 * @param Id
	 *            the id
	 * @return the customer
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer findById(@PathVariable("id") String Id) {
		return customerService.findById(Id);
	}

	/**
	 * Find by email.
	 *
	 * @param email
	 *            the email
	 * @return the customer
	 */
	@RequestMapping(value = "/email/{email}", headers = "Accept=*/*", method = RequestMethod.GET)
	public Customer findByEmail(@PathVariable("email") String email) {

		return customerService.findByEmail(email);
	}

	/**
	 * Update.
	 *
	 * @param id
	 *            the id
	 * @param customer
	 *            the customer
	 * @return the customer
	 */
	@RequestMapping(value = "{/id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.PUT)
	public Customer update(@PathVariable("id") String id, @RequestBody Customer customer) {

		return customerService.update(id, customer);
	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		customerService.delete(id);
	}

}
