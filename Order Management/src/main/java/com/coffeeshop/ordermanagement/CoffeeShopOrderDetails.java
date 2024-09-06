package com.coffeeshop.ordermanagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoffeeShopOrderDetails {

	public CoffeeShopOrderDetails () {
	}

	public CoffeeShopOrderDetails (
		String country, 
		String pickupTime, 
		java.math.BigDecimal orderId, 
		java.math.BigDecimal requestId, 
		String specialInstructions, 
		String source, 
		java.math.BigDecimal storeId, 
		Items[] items) {
		this.country = country;
		this.pickupTime = pickupTime;
		this.orderId = orderId;
		this.requestId = requestId;
		this.specialInstructions = specialInstructions;
		this.source = source;
		this.storeId = storeId;
		this.items = items;
	}

	private String country;
	private String pickupTime;
	private java.math.BigDecimal orderId;
	private java.math.BigDecimal requestId;
	private String specialInstructions;
	private String source;
	private java.math.BigDecimal storeId;
	private Items[] items;
	public String getCountry() {
		return country;
	}

	public CoffeeShopOrderDetails setCountry(String country) {
		this.country = country;
		return this;
	}


	public String getPickupTime() {
		return pickupTime;
	}

	public CoffeeShopOrderDetails setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
		return this;
	}


	public java.math.BigDecimal getOrderId() {
		return orderId;
	}

	public CoffeeShopOrderDetails setOrderId(java.math.BigDecimal orderId) {
		this.orderId = orderId;
		return this;
	}


	public java.math.BigDecimal getRequestId() {
		return requestId;
	}

	public CoffeeShopOrderDetails setRequestId(java.math.BigDecimal requestId) {
		this.requestId = requestId;
		return this;
	}


	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public CoffeeShopOrderDetails setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
		return this;
	}


	public String getSource() {
		return source;
	}

	public CoffeeShopOrderDetails setSource(String source) {
		this.source = source;
		return this;
	}


	public java.math.BigDecimal getStoreId() {
		return storeId;
	}

	public CoffeeShopOrderDetails setStoreId(java.math.BigDecimal storeId) {
		this.storeId = storeId;
		return this;
	}


	public Items[] getItems() {
		return items;
	}

	public CoffeeShopOrderDetails setItems(Items[] items) {
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
			String size, 
			String[] options, 
			String productName) {
			this.quantity = quantity;
			this.productId = productId;
			this.size = size;
			this.options = options;
			this.productName = productName;
		}


		private java.math.BigDecimal quantity;
		@JsonProperty("productID")
		private String productId;
		private String size;
		private String[] options;
		private String productName;
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


		public String getSize() {
			return size;
		}

		public Items setSize(String size) {
			this.size = size;
			return this;
		}


		public String[] getOptions() {
			return options;
		}

		public Items setOptions(String[] options) {
			this.options = options;
			return this;
		}


		public String getProductName() {
			return productName;
		}

		public Items setProductName(String productName) {
			this.productName = productName;
			return this;
		}

		public String toString() {
			return "Items ["
			+ " quantity: " + quantity
			+ " productId: " + productId
			+ " size: " + size
			+ " options: " + options
			+ " productName: " + productName
			+ " ]";
		}
	}
	public String toString() {
		return "CoffeeShopOrderDetails ["
		+ " country: " + country
		+ " pickupTime: " + pickupTime
		+ " orderId: " + orderId
		+ " requestId: " + requestId
		+ " specialInstructions: " + specialInstructions
		+ " source: " + source
		+ " storeId: " + storeId
		+ " items: " + items
		+ " ]";
	}
}
