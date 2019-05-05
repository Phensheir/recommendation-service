package com.hsbc.ins.rec.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="t_favourite")
public class CusFavourite implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8094953880591002542L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fav_id")
	private long favouriteId;
	
	@OneToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "customerId", referencedColumnName = "user_id")
	private Customer customer;
	
	@OneToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "productId", referencedColumnName = "goods_id")
	private Product product;
	
	@Column(name="crt_datetime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public long getFavouriteId() {
		return favouriteId;
	}

	public void setFavouriteId(long favouriteId) {
		this.favouriteId = favouriteId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
