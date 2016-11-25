package com.equipme.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equipme.model.Orders;

@Transactional
@Service
public class OrderServiceImpl {
	@PersistenceContext
	private EntityManager em;

	public Orders create(Orders order) {
		em.persist(order);

		return order;
	}

	public List<Orders> findAll() {

		TypedQuery<Orders> orders = em.createQuery("SELECT o FROM Orders o", Orders.class);
		return orders.getResultList();
	}

	public Orders update(Orders order) {

		em.merge(order);
		return order;
	}

	public void delete(String id) {

		Orders existing = em.find(Orders.class, id);
		em.remove(existing);
	}

}
