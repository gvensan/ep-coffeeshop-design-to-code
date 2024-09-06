package com.coffeeshop.ordermanagement;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private StreamBridge streamBridge;

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public Consumer<CoffeeShopOrderReady> coffeeshopOrderStatusV1ReadySourceCountryStoreIdOrderIdConsumer() {
		return data -> {
			// Add business logic here.	
			logger.info(data.toString());
		};
	}

	@Bean
	public Consumer<CoffeeShopOrderEta> coffeeshopOrderStatusV1InprogressSourceCountryStoreIdOrderIdConsumer() {
		return data -> {
			// Add business logic here.	
			logger.info(data.toString());
		};
	}



	@Bean
	public Consumer<CoffeeShopOrderStatus> coffeeshopOrderStatusV1CompletedSourceCountryStoreIdOrderIdConsumer() {
		return order -> {
			// Add business logic here.	
			logger.info(String.format("\nOrder Completed:\n %s", order));
		};
	}

	@Bean
	public Consumer<CoffeeShopInventory> coffeeshopOrderStatusV1OutofstockSourceCountryStoreIdOrderIdConsumer() {
		return data -> {
			// Add business logic here.	
			logger.info(data.toString());
		};
	}

	@Bean
	public Consumer<CoffeeShopNewOrder> coffeeshopOrderNewV1SourceCountryStoreIdRequestIdConsumer() {
		return order -> {
			// Add business logic here.	
			logger.info(String.format("\nNew Order received:\n %s", order));
			CoffeeShopNewOrder.Items[] items = order.getItems();
			CoffeeShopOrderDetails.Items item1 = new CoffeeShopOrderDetails.Items()
					.setQuantity(items[0].getQuantity())
					.setProductId(items[0].getProductId())
					.setSize(items[0].getSize())
					.setOptions(items[0].getOptions())
					.setProductName(items[0].getProductName());
			CoffeeShopOrderDetails.Items item2 = new CoffeeShopOrderDetails.Items()
					.setQuantity(items[1].getQuantity())
					.setProductId(items[1].getProductId())
					.setSize(items[1].getSize())
					.setOptions(items[1].getOptions())
					.setProductName(items[1].getProductName());
			CoffeeShopOrderDetails.Items[] orderItems = {item1, item2};

			Random random = new Random();
			CoffeeShopOrderDetails orderDetails = new CoffeeShopOrderDetails()
					.setCountry(order.getCountry())
					.setPickupTime(order.getPickupTime())
					.setOrderId(new java.math.BigDecimal(random.nextInt(1000)))
					.setRequestId(order.getRequestId())
					.setSpecialInstructions(order.getSpecialInstructions())
					.setSource(order.getSource())
					.setStoreId(order.getStoreId())
					.setItems(orderItems);

			logger.info(String.format("\nPublishing Order Details:\n %s", order));
			String topic = String.format("coffeeshop/order/details/v1/%s/%s/%s/%s",
					orderDetails.getSource(), orderDetails.getCountry(), orderDetails.getStoreId(), orderDetails.getOrderId());
			streamBridge.send(topic, orderDetails);
		};
	}

	public void sendCoffeeshopOrderUpdateV1SourceCountryStoreIdRequestId(
		CoffeeShopOrderStatus payload, String source, String country, String storeId, String requestId
		) {
		String topic = String.format("coffeeshop/order/update/v1/%s/%s/%s/%s",
			source, country, storeId, requestId);
		streamBridge.send(topic, payload);
	}
	public void sendCoffeeshopOrderDetailsV1SourceCountryStoreIdOrderId(
		CoffeeShopOrderDetails payload, String source, String country, String storeId, String orderId
		) {
		String topic = String.format("coffeeshop/order/details/v1/%s/%s/%s/%s",
			source, country, storeId, orderId);
		streamBridge.send(topic, payload);
	}

	@Scheduled(fixedRate = 10000)
	public void placeNewOrders() {
		List<String> sources = Arrays.asList("web", "mobile", "phone");
		List<String> countries = Arrays.asList("us", "ca", "uk");
		List<String> products = Arrays.asList("Americano", "Cappuccino", "Espresso", "Latte", "Mocha", "Tea");
		List<String> productIds = Arrays.asList("123", "455", "545", "233", "977", "644");
		List<String> sizes = Arrays.asList("Small", "Medium", "Large");
		List<String> specialInstructions = Arrays.asList("extra hot", "extra cream", "extra sugar", "no sugar");

		Random random = new Random();
		CoffeeShopNewOrder order = new CoffeeShopNewOrder()
				.setCountry(countries.get(random.nextInt(countries.size())))
				.setPickupTime(Instant.now().toString())
				.setTotalPrice(new java.math.BigDecimal(random.nextInt(100)))
				.setRequestId(new java.math.BigDecimal(random.nextInt(1000)))
				.setSpecialInstructions(specialInstructions.get(random.nextInt(specialInstructions.size())))
				.setSource(sources.get(random.nextInt(sources.size())))
				.setStoreId(new java.math.BigDecimal(random.nextInt(1000)));
		int productNum = random.nextInt(products.size());
		CoffeeShopNewOrder.Items item1 = new CoffeeShopNewOrder.Items(
				new java.math.BigDecimal(random.nextInt(5)),
				productIds.get(productNum),
				sizes.get(random.nextInt(sizes.size())),
				new String[]{"Extra cream", "Extra sugar"}, // options
				products.get(productNum)
		);

		productNum = random.nextInt(products.size());
		CoffeeShopNewOrder.Items item2 = new CoffeeShopNewOrder.Items(
				new java.math.BigDecimal(random.nextInt(5)),
				productIds.get(productNum),
				sizes.get(random.nextInt(sizes.size())),
				new String[]{"No sugar"}, // options
				products.get(productNum)
		);

		order.setItems(new CoffeeShopNewOrder.Items[]{item1, item2});
		CoffeeShopNewOrder.Items[] items = {item1, item2};
		order.setItems(items);

		CoffeeShopNewOrder.Customer customer = new CoffeeShopNewOrder.Customer()
				.setName("John Smith")
				.setEmail("john.smith@domain.com")
				.setPhone("123-456-7890");
		order.setCustomer(customer);

		logger.info(String.format("\nPlacing New Order:\n %s", order));

		String topic = String.format("coffeeshop/order/new/v1/%s/%s/%s/%s",
				order.getSource(),
				countries.get(random.nextInt(countries.size())),
				order.getStoreId().toString(),
				order.getRequestId().toString());

		logger.info(String.format("\nSending new order with requestId: %s on topic: %s\n", order.getRequestId(), topic));

		streamBridge.send(topic, order);
	}

}
