package com.equipme.repository;

import java.util.List;
import com.equipme.model.Customer;
import com.equipme.model.Orders;

public interface OrdersRepository {

	public Orders create(Orders orders);

	public List<Orders> findAll();

	public Orders findById(String id);

	public Orders update(Orders orders);

	public void delete(Orders id);

	public List<Orders> findOrdersByCustomer(Customer id);

}
