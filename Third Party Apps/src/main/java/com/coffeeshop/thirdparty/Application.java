package com.coffeeshop.thirdparty;


import java.util.function.Consumer;
import java.util.function.Supplier;

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
	public Consumer<CoffeeShopOrderStatus> coffeeshopOrderUpdateV1SourceCountryStoreIdRequestIdConsumer() {
		return data -> {
			// Add business logic here.	
      logger.info(String.format("\nReceived Order Confirmation:\n %s", data));
		};
	}


  public void sendCoffeeshopOrderNewV1SourceCountryStoreIdRequestId(
		CoffeeShopNewOrder payload, String source, String country, String storeId, String requestId
		) {
    logger.info(String.format("\nPublishing New Order:\n %s", payload));

    String topic = String.format("coffeeshop/order/new/v1/%s/%s/%s/%s",
    source, country, storeId, requestId);

		streamBridge.send(topic, payload);
	}
}
