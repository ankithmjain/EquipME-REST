package com.equipme.service;

import java.util.List;
import com.equipme.model.Orders;

public interface OrdersService {

	public Orders create(Orders orders);

	public List<Orders> findAll();

	public Orders findById(String id);

	public Orders update(String id, Orders orders);

	public void delete(String orderId);

}
