package com.equipme.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class Product.
 */
@NamedQueries(value = {
		@NamedQuery(name = "Product.findBySkuCode", query = "Select p from Product p WHERE p.skuCode = :skuCode"),
		@NamedQuery(name = "Product.findAllProducts", query = "Select p from Product p ORDER BY p.productName") })

@Entity
@Table
public class Product {

	/** The id. */
	@Id
	private String id;

	/** The product name. */
	@Size(min = 1, max = 100)
	private String productName;

	/** The product category. */
	@Size(min = 1, max = 100)
	private String productCategory;

	/** The product quantity. */
	@Size(min = 1, max = 200)
	private Integer productQuantity;

	/** The product price. */
	private Integer productPrice;

	/**
	 * Gets the product quantity.
	 *
	 * @return the product quantity
	 */
	public Integer getProductQuantity() {
		return productQuantity;
	}

	/**
	 * Sets the product quantity.
	 *
	 * @param productQuantity
	 *            the new product quantity
	 */
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * Gets the product price.
	 *
	 * @return the product price
	 */
	public Integer getProductPrice() {
		return productPrice;
	}

	/**
	 * Sets the product price.
	 *
	 * @param productPrice
	 *            the new product price
	 */
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * Gets the product image url.
	 *
	 * @return the product image url
	 */
	public String getProductImageUrl() {
		return productImageUrl;
	}

	/**
	 * Sets the product image url.
	 *
	 * @param productImageUrl
	 *            the new product image url
	 */
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	/** The product image url. */
	private String productImageUrl;

	/** The sku code. */
	@Column(unique = true)
	private String skuCode;

	/**
	 * Instantiates a new product.
	 */
	public Product() {
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
	 * @param pid
	 *            the new id
	 */
	public void setId(String pid) {
		this.id = pid;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName
	 *            the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the product category.
	 *
	 * @return the product category
	 */
	public String getProductCategory() {
		return productCategory;
	}

	/**
	 * Sets the product category.
	 *
	 * @param productCategory
	 *            the new product category
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * Gets the sku code.
	 *
	 * @return the sku code
	 */
	public String getSkuCode() {
		return skuCode;
	}

	/**
	 * Sets the sku code.
	 *
	 * @param skuCode
	 *            the new sku code
	 */
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productCategory=" + productCategory
				+ ", skuCode=" + skuCode + "]";
	}

}
