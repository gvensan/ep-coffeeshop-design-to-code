package com.coffeeshop.baristastation;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoffeeShopOrderEta {

	public CoffeeShopOrderEta () {
	}

	public CoffeeShopOrderEta (
		String country, 
		String eta, 
		java.math.BigDecimal orderId, 
		java.math.BigDecimal requestId, 
		String source, 
		java.math.BigDecimal storeId) {
		this.country = country;
		this.eta = eta;
		this.orderId = orderId;
		this.requestId = requestId;
		this.source = source;
		this.storeId = storeId;
	}

	private String country;
	private String eta;
	private java.math.BigDecimal orderId;
	private java.math.BigDecimal requestId;
	private String source;
	private java.math.BigDecimal storeId;
	public String getCountry() {
		return country;
	}

	public CoffeeShopOrderEta setCountry(String country) {
		this.country = country;
		return this;
	}


	public String getEta() {
		return eta;
	}

	public CoffeeShopOrderEta setEta(String eta) {
		this.eta = eta;
		return this;
	}


	public java.math.BigDecimal getOrderId() {
		return orderId;
	}

	public CoffeeShopOrderEta setOrderId(java.math.BigDecimal orderId) {
		this.orderId = orderId;
		return this;
	}


	public java.math.BigDecimal getRequestId() {
		return requestId;
	}

	public CoffeeShopOrderEta setRequestId(java.math.BigDecimal requestId) {
		this.requestId = requestId;
		return this;
	}


	public String getSource() {
		return source;
	}

	public CoffeeShopOrderEta setSource(String source) {
		this.source = source;
		return this;
	}


	public java.math.BigDecimal getStoreId() {
		return storeId;
	}

	public CoffeeShopOrderEta setStoreId(java.math.BigDecimal storeId) {
		this.storeId = storeId;
		return this;
	}

	public String toString() {
		return "CoffeeShopOrderEta ["
		+ " country: " + country
		+ " eta: " + eta
		+ " orderId: " + orderId
		+ " requestId: " + requestId
		+ " source: " + source
		+ " storeId: " + storeId
		+ " ]";
	}
}
