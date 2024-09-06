package com.coffeeshop.baristastation;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoffeeShopOrderStatus {

	public CoffeeShopOrderStatus () {
	}

	public CoffeeShopOrderStatus (
		String country, 
		java.math.BigDecimal orderId, 
		java.math.BigDecimal requestId, 
		String source, 
		java.math.BigDecimal storeId, 
		String status) {
		this.country = country;
		this.orderId = orderId;
		this.requestId = requestId;
		this.source = source;
		this.storeId = storeId;
		this.status = status;
	}

	private String country;
	private java.math.BigDecimal orderId;
	private java.math.BigDecimal requestId;
	private String source;
	private java.math.BigDecimal storeId;
	private String status;
	public String getCountry() {
		return country;
	}

	public CoffeeShopOrderStatus setCountry(String country) {
		this.country = country;
		return this;
	}


	public java.math.BigDecimal getOrderId() {
		return orderId;
	}

	public CoffeeShopOrderStatus setOrderId(java.math.BigDecimal orderId) {
		this.orderId = orderId;
		return this;
	}


	public java.math.BigDecimal getRequestId() {
		return requestId;
	}

	public CoffeeShopOrderStatus setRequestId(java.math.BigDecimal requestId) {
		this.requestId = requestId;
		return this;
	}


	public String getSource() {
		return source;
	}

	public CoffeeShopOrderStatus setSource(String source) {
		this.source = source;
		return this;
	}


	public java.math.BigDecimal getStoreId() {
		return storeId;
	}

	public CoffeeShopOrderStatus setStoreId(java.math.BigDecimal storeId) {
		this.storeId = storeId;
		return this;
	}


	public String getStatus() {
		return status;
	}

	public CoffeeShopOrderStatus setStatus(String status) {
		this.status = status;
		return this;
	}

	public String toString() {
		return "CoffeeShopOrderStatus ["
		+ " country: " + country
		+ " orderId: " + orderId
		+ " requestId: " + requestId
		+ " source: " + source
		+ " storeId: " + storeId
		+ " status: " + status
		+ " ]";
	}
}
