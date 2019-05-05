package com.hsbc.ins.rec.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9171210964311100342L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDER_id")
	private long orderId;
	
	@Column(name="order_code", length=30)
	private String orderCode;
	
	@OneToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "user_id")
	private Customer customer;
	
	@OneToMany(cascade=CascadeType.DETACH)
	@JoinColumn(name = "goods_id")
	private List<Product> products;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
