package com.equipme.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.equipme.model.Customer;
import com.equipme.model.Orders;

@Repository
public class OrdersRepositoryImpl implements OrdersRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Orders create(Orders orders) {
		em.persist(orders);
		return orders;
	}

	@Override
	public List<Orders> findAll() {

		TypedQuery<Orders> orders = em.createNamedQuery("Orders.findAllOrders", Orders.class);
		return orders.getResultList();

	}

	@Override
	public List<Orders> findOrdersByCustomer(Customer id) {

		TypedQuery<Orders> ordersCustomer = em.createNamedQuery("Orders.findByCustomer", Orders.class);
		ordersCustomer.setParameter("customer", id);
		List<Orders> orders = ordersCustomer.getResultList();
		if (orders != null && orders.size() == 1) {
			return orders;
		}
		return null;
	}

	@Override
	public Orders findById(String id) {

		return em.find(Orders.class, id);
	}

	@Override
	public Orders update(Orders orders) {
		em.merge(orders);
		return orders;
	}

	@Override
	public void delete(Orders id) {

		em.remove(id);
	}

}
