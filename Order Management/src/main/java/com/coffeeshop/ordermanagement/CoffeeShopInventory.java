package com.coffeeshop.ordermanagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoffeeShopInventory {

	public CoffeeShopInventory () {
	}

	public CoffeeShopInventory (
		String country, 
		java.math.BigDecimal orderId, 
		java.math.BigDecimal requestId, 
		String source, 
		java.math.BigDecimal storeId, 
		Items[] items) {
		this.country = country;
		this.orderId = orderId;
		this.requestId = requestId;
		this.source = source;
		this.storeId = storeId;
		this.items = items;
	}

	private String country;
	private java.math.BigDecimal orderId;
	private java.math.BigDecimal requestId;
	private String source;
	private java.math.BigDecimal storeId;
	private Items[] items;
	public String getCountry() {
		return country;
	}

	public CoffeeShopInventory setCountry(String country) {
		this.country = country;
		return this;
	}


	public java.math.BigDecimal getOrderId() {
		return orderId;
	}

	public CoffeeShopInventory setOrderId(java.math.BigDecimal orderId) {
		this.orderId = orderId;
		return this;
	}


	public java.math.BigDecimal getRequestId() {
		return requestId;
	}

	public CoffeeShopInventory setRequestId(java.math.BigDecimal requestId) {
		this.requestId = requestId;
		return this;
	}


	public String getSource() {
		return source;
	}

	public CoffeeShopInventory setSource(String source) {
		this.source = source;
		return this;
	}


	public java.math.BigDecimal getStoreId() {
		return storeId;
	}

	public CoffeeShopInventory setStoreId(java.math.BigDecimal storeId) {
		this.storeId = storeId;
		return this;
	}


	public Items[] getItems() {
		return items;
	}

	public CoffeeShopInventory setItems(Items[] items) {
		this.items = items;
		return this;
	}



	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class Items {

		public Items () {
		}
		public Items (
			java.math.BigDecimal quantity, 
			String productId, 
			String productName, 
			String status) {
			this.quantity = quantity;
			this.productId = productId;
			this.productName = productName;
			this.status = status;
		}


		private java.math.BigDecimal quantity;
		@JsonProperty("productID")
		private String productId;
		private String productName;
		private String status;
		public java.math.BigDecimal getQuantity() {
			return quantity;
		}

		public Items setQuantity(java.math.BigDecimal quantity) {
			this.quantity = quantity;
			return this;
		}


		public String getProductId() {
			return productId;
		}

		public Items setProductId(String productId) {
			this.productId = productId;
			return this;
		}


		public String getProductName() {
			return productName;
		}

		public Items setProductName(String productName) {
			this.productName = productName;
			return this;
		}


		public String getStatus() {
			return status;
		}

		public Items setStatus(String status) {
			this.status = status;
			return this;
		}

		public String toString() {
			return "Items ["
			+ " quantity: " + quantity
			+ " productId: " + productId
			+ " productName: " + productName
			+ " status: " + status
			+ " ]";
		}
	}
	public String toString() {
		return "CoffeeShopInventory ["
		+ " country: " + country
		+ " orderId: " + orderId
		+ " requestId: " + requestId
		+ " source: " + source
		+ " storeId: " + storeId
		+ " items: " + items
		+ " ]";
	}
}
