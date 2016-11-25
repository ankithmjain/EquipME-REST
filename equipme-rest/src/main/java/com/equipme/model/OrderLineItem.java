package com.equipme.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The Class OrderLineItem.
 */
@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class OrderLineItem {

	/** The id. */
	@Id
	private String id;

	/** The product. */
	@OneToOne
	private Product product;

	/** The qty. */
	@Size(min = 1, max = 20)
	private Integer qty;

	/**
	 * Instantiates a new order line item.
	 */
	public OrderLineItem() {
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
	 * Gets the product.
	 *
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Sets the product.
	 *
	 * @param product
	 *            the new product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Gets the qty.
	 *
	 * @return the qty
	 */
	public Integer getQty() {
		return qty;
	}

	/**
	 * Sets the qty.
	 *
	 * @param qty
	 *            the new qty
	 */
	public void setQty(Integer qty) {
		this.qty = qty;
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
		OrderLineItem other = (OrderLineItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderLineItem [id=" + id + ", product=" + product + ", qty=" + qty + "]";
	}

}
