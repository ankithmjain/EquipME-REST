package com.equipme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.equipme.model.Orders;
import com.equipme.repository.OrdersRepository;

@Transactional
@Service
public class OrdersServiceImp implements OrdersService {

	@Autowired
	public OrdersRepository ordersRepository;

	@Override
	public Orders create(Orders orders) {
		Orders existing = ordersRepository.findById(orders.getId());
		if (existing != null) {
			return null;
		}

		return ordersRepository.create(orders);
	}

	@Override
	public List<Orders> findAll() {

		List<Orders> orders = ordersRepository.findAll();
		if (orders == null) {
			return null;
		}
		return orders;
	}

	@Override
	public Orders findById(String id) {

		Orders orders = ordersRepository.findById(id);
		if (orders == null) {
			return null;
		}
		return orders;
	}

	@Override
	public Orders update(String id, Orders orders) {
		Orders existing = ordersRepository.findById(id);
		if (existing == null) {

			return null;
		}
		return ordersRepository.update(orders);
	}

	@Override
	public void delete(String ordersId) {

		Orders existing = ordersRepository.findById(ordersId);

		if (existing == null) {

			// handle exception
		}
		ordersRepository.delete(existing);

	}

}
