package com.coffeeshop.baristastation;

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

@SpringBootApplication
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
	public Consumer<CoffeeShopOrderDetails> coffeeshopOrderDetailsV1SourceCountryStoreIdOrderIdConsumer() {
		return data -> {
			// Add business logic here.	
			logger.info(data.toString());
		};
	}

	@Bean
	public Consumer<CoffeeShopInventory> coffeeshopOrderStatusV1OutofstockSourceCountryStoreIdOrderIdConsumer() {
		return data -> {
			// Add business logic here.	
			logger.info(data.toString());
		};
	}

	public void sendCoffeeshopOrderStatusV1CompletedSourceCountryStoreIdOrderId(
		CoffeeShopOrderStatus payload, String source, String country, String storeId, String orderId
		) {
		String topic = String.format("coffeeshop/order/status/v1/completed/%s/%s/%s/%s",
			source, country, storeId, orderId);
		streamBridge.send(topic, payload);
	}
}
