package com.coffeeshop.ordermanagement;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoffeeShopOrderReady {

	public CoffeeShopOrderReady () {
	}

	public CoffeeShopOrderReady (
		String country, 
		java.math.BigDecimal orderId, 
		java.math.BigDecimal requestId, 
		String source, 
		java.math.BigDecimal storeId) {
		this.country = country;
		this.orderId = orderId;
		this.requestId = requestId;
		this.source = source;
		this.storeId = storeId;
	}

	private String country;
	private java.math.BigDecimal orderId;
	private java.math.BigDecimal requestId;
	private String source;
	private java.math.BigDecimal storeId;
	public String getCountry() {
		return country;
	}

	public CoffeeShopOrderReady setCountry(String country) {
		this.country = country;
		return this;
	}


	public java.math.BigDecimal getOrderId() {
		return orderId;
	}

	public CoffeeShopOrderReady setOrderId(java.math.BigDecimal orderId) {
		this.orderId = orderId;
		return this;
	}


	public java.math.BigDecimal getRequestId() {
		return requestId;
	}

	public CoffeeShopOrderReady setRequestId(java.math.BigDecimal requestId) {
		this.requestId = requestId;
		return this;
	}


	public String getSource() {
		return source;
	}

	public CoffeeShopOrderReady setSource(String source) {
		this.source = source;
		return this;
	}


	public java.math.BigDecimal getStoreId() {
		return storeId;
	}

	public CoffeeShopOrderReady setStoreId(java.math.BigDecimal storeId) {
		this.storeId = storeId;
		return this;
	}

	public String toString() {
		return "CoffeeShopOrderReady ["
		+ " country: " + country
		+ " orderId: " + orderId
		+ " requestId: " + requestId
		+ " source: " + source
		+ " storeId: " + storeId
		+ " ]";
	}
}
