package com.coffeeshop.ordermanagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoffeeShopNewOrder {

	public CoffeeShopNewOrder () {
	}

	public CoffeeShopNewOrder (
		String country, 
		String pickupTime, 
		java.math.BigDecimal totalPrice, 
		java.math.BigDecimal requestId, 
		String specialInstructions, 
		String source, 
		java.math.BigDecimal storeId, 
		Items[] items, 
		Customer customer) {
		this.country = country;
		this.pickupTime = pickupTime;
		this.totalPrice = totalPrice;
		this.requestId = requestId;
		this.specialInstructions = specialInstructions;
		this.source = source;
		this.storeId = storeId;
		this.items = items;
		this.customer = customer;
	}

	private String country;
	private String pickupTime;
	private java.math.BigDecimal totalPrice;
	private java.math.BigDecimal requestId;
	private String specialInstructions;
	private String source;
	private java.math.BigDecimal storeId;
	private Items[] items;
	private Customer customer;
	public String getCountry() {
		return country;
	}

	public CoffeeShopNewOrder setCountry(String country) {
		this.country = country;
		return this;
	}


	public String getPickupTime() {
		return pickupTime;
	}

	public CoffeeShopNewOrder setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
		return this;
	}


	public java.math.BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public CoffeeShopNewOrder setTotalPrice(java.math.BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}


	public java.math.BigDecimal getRequestId() {
		return requestId;
	}

	public CoffeeShopNewOrder setRequestId(java.math.BigDecimal requestId) {
		this.requestId = requestId;
		return this;
	}


	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public CoffeeShopNewOrder setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
		return this;
	}


	public String getSource() {
		return source;
	}

	public CoffeeShopNewOrder setSource(String source) {
		this.source = source;
		return this;
	}


	public java.math.BigDecimal getStoreId() {
		return storeId;
	}

	public CoffeeShopNewOrder setStoreId(java.math.BigDecimal storeId) {
		this.storeId = storeId;
		return this;
	}


	public Items[] getItems() {
		return items;
	}

	public CoffeeShopNewOrder setItems(Items[] items) {
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

	public Customer getCustomer() {
		return customer;
	}

	public CoffeeShopNewOrder setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}



	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class Customer {

		public Customer () {
		}

		public Customer (
			String phone, 
			String name, 
			String email) {
			this.phone = phone;
			this.name = name;
			this.email = email;
		}

		private String phone;
		private String name;
		private String email;
		public String getPhone() {
			return phone;
		}

		public Customer setPhone(String phone) {
			this.phone = phone;
			return this;
		}


		public String getName() {
			return name;
		}

		public Customer setName(String name) {
			this.name = name;
			return this;
		}


		public String getEmail() {
			return email;
		}

		public Customer setEmail(String email) {
			this.email = email;
			return this;
		}

		public String toString() {
			return "Customer ["
			+ " phone: " + phone
			+ " name: " + name
			+ " email: " + email
			+ " ]";
		}
	}
	public String toString() {
		return "CoffeeShopNewOrder ["
		+ " country: " + country
		+ " pickupTime: " + pickupTime
		+ " totalPrice: " + totalPrice
		+ " requestId: " + requestId
		+ " specialInstructions: " + specialInstructions
		+ " source: " + source
		+ " storeId: " + storeId
		+ " items: " + items
		+ " customer: " + customer
		+ " ]";
	}
}
