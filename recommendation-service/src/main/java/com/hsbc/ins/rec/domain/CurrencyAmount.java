package com.hsbc.ins.rec.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class CurrencyAmount implements Serializable {
	
	private static final long serialVersionUID = 4255516540680315808L;

	@Column(name="goods_price")
	private BigDecimal amount;
	
	@Transient
	private String currencyCode;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
}
