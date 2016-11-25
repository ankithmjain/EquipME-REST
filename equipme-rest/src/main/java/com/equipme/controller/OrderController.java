package com.equipme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equipme.model.Orders;
import com.equipme.service.OrdersService;

/**
 * The Class OrderController.
 */
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class OrderController {

	/** The orders service. */
	@Autowired
	private OrdersService ordersService;

	/**
	 * Creates the order.
	 *
	 * @param order
	 *            the order
	 * @return the orders
	 */
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Orders createOrder(@RequestBody Orders order) {

		System.out.println(order);
		return ordersService.create(order);
	}

	/**
	 * Find all orders.
	 *
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Orders> findAllOrders() {

		return ordersService.findAll();
	}

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the orders
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Orders findById(@PathVariable String id) {

		return ordersService.findById(id);
	}

	/**
	 * Update.
	 *
	 * @param id
	 *            the id
	 * @param order
	 *            the order
	 * @return the orders
	 */
	@RequestMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.PUT)
	public Orders update(@PathVariable("id") String id, @RequestBody Orders order) {

		return ordersService.update(id, order);
	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {

		ordersService.delete(id);
	}

}
