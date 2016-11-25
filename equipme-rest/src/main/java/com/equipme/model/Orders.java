package com.equipme.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The Class Orders.
 */
@NamedQueries(value = {
		@NamedQuery(name = "Orders.findByCustomer", query = "Select o from Orders o WHERE o.customer = :customer"),
		@NamedQuery(name = "Orders.findAllOrders", query = "Select o from Orders o ORDER BY o.status") })

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Orders {

	/** The id. */
	@Id
	private String id;

	/** The order line item. */
	@OneToMany(cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderLineItem> orderLineItem = new ArrayList<OrderLineItem>();

	/** The status. */
	private String status;

	/** The customer. */
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;

	/**
	 * Instantiates a new orders.
	 */
	public Orders() {
		id = UUID.randomUUID().toString();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the order line item.
	 *
	 * @return the order line item
	 */
	public List<OrderLineItem> getOrderLineItem() {
		return orderLineItem;
	}

	/**
	 * Sets the order line item.
	 *
	 * @param orderLineItem
	 *            the new order line item
	 */
	public void setOrderLineItem(List<OrderLineItem> orderLineItem) {
		this.orderLineItem = orderLineItem;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer
	 *            the new customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderLineItem=" + orderLineItem + ", status=" + status + ", customer=" + customer
				+ "]";
	}

}
