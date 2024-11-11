[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-v2.0%20adopted-ff69b4.svg)](code_of_conduct.md)

# Streamlining EDA Design and Code Generation

## Overview
This repo contains code artifacts that were used in my Streamlining EDA Design and Code Generation with PubSub+ Event Portal and AsyncAPI.

[Coming soon...]()

## Getting started with PubSub+ Broker

[solace.dev](https://www.solace.dev/) - Download a docker image to software broker locally on your machine, or signup for a free cloud trial account.

## Coffee Shop Application Domain

![image](https://github.com/user-attachments/assets/6e08c06e-1989-4960-89f2-c52d7c6fa126)



## Artifacts
- *ep_coffeeshop_order_management_domain.json.json*: EP export of CoffeeShop Application Domain
- *Order Management-0.1.0.json*: AsyncAPI document for **Order Management** Application
- *Barista Station-0.1.0.json*: AsyncAPI document for **Barista Station** Application
- *Order Management/*: Directory containing spring cloud stream application (code) generated from the *Order Management-0.1.0.json* AsyncAPI document using **asyncapi-generator** utility
- *Barista Station/*: Directory containing spring cloud stream application (code) generated from the *Barista Station-0.1.0.json* AsyncAPI document using **asyncapi-generator** utility
  
## Checking out

To check out the project, clone this GitHub repository:

```
git clone https://github.com/gvensan/ep-coffeeshop-design-to-code.git
cd <ep-coffeeshop-design-to-code>
```

The code demonstrates the following actions:

1. Order Management Application
   * Configured to publish new order every 10 seconds
   * Configured to publish order details upon receiving new order
   * Configured to receive (subscribe) order completed event
2. Barista Station Application
   * Configured to receive (subscribe) order details event
   * Configured publish an order completed event for every received order details event

If you want to start afresh and build your own logic, you can generate spring-cloud-stream code using asyncapi-generator.

For Order Management application:
```
asyncapi-generator -p binder=solace -p artifactId=CoffeeShop -p groupId=com.coffeeshop -p javaPackage=com.coffeeshop.ordermanagement -p actuator=true "Order Management-0.1.0.json" @asyncapi/java-spring-cloud-stream-template -o "Order Management"
```

For Barista Station application:
```
asyncapi-generator -p binder=solace -p artifactId=CoffeeShop -p groupId=com.coffeeshop -p javaPackage=com.coffeeshop.baristastation -p actuator=true "Barista Station-0.1.0.json" @asyncapi/java-spring-cloud-stream-template -o "Barista Station"
```

## Running the Demo

Open a terminal:

```
cd Barista\ Station
mvn clean spring-boot:run
```

Open another terminal:
```
cd Order\ Management
mvn clean spring-boot:run
```

You can watch new orders placed by *Order Management* application getting processed by the *Barista Station* application.

On terminal#1:
```
2024-09-06 17:13:04.721  INFO 39472 --- [pool-8-thread-1] c.c.ordermanagement.Application          :
New Order received:
 CoffeeShopNewOrder [ country: uk pickupTime: 2024-09-06T11:43:04.667464Z totalPrice: 43 requestId: 982 specialInstructions: no sugar source: mobile storeId: 440 items: [Lcom.coffeeshop.ordermanagement.CoffeeShopNewOrder$Items;@388debb customer: Customer [ phone: 123-456-7890 name: John Smith email: john.smith@domain.com ] ]
2024-09-06 17:13:04.721  INFO 39472 --- [pool-8-thread-1] c.c.ordermanagement.Application          :
Publishing Order Details:
 CoffeeShopNewOrder [ country: uk pickupTime: 2024-09-06T11:43:04.667464Z totalPrice: 43 requestId: 982 specialInstructions: no sugar source: mobile storeId: 440 items: [Lcom.coffeeshop.ordermanagement.CoffeeShopNewOrder$Items;@388debb customer: Customer [ phone: 123-456-7890 name: John Smith email: john.smith@domain.com ] ]
2024-09-06 17:13:04.736  INFO 39472 --- [pool-8-thread-1] o.s.c.s.binder.DefaultBinderFactory      : Retrieving cached binder: solace-binder
2024-09-06 17:13:04.762  INFO 39472 --- [pool-8-thread-1] .s.s.c.s.b.o.JCSMPOutboundMessageHandler : Creating producer to topic coffeeshop/order/details/v1/mobile/uk/440/702 <message handler ID: 9dd31a07-c8f8-4a49-94fd-8a81b1a33a2d>
2024-09-06 17:13:04.762  INFO 39472 --- [pool-8-thread-1] o.s.c.s.m.DirectWithAttributesChannel    : Channel 'unknown.channel.name' has 1 subscriber(s).
2024-09-06 17:13:04.866  INFO 39472 --- [pool-6-thread-1] c.c.ordermanagement.Application          :
Order Completed:
 CoffeeShopOrderStatus [ country: uk orderId: 702 requestId: 982 source: mobile storeId: 440 status: READY ]
 ```

On terminal#2:
```
2024-09-06 17:13:04.775  INFO 39500 --- [pool-6-thread-1] c.coffeeshop.baristastation.Application  :
New Order received:
 CoffeeShopOrderDetails [ country: uk pickupTime: 2024-09-06T11:43:04.667464Z orderId: 702 requestId: 982 specialInstructions: no sugar source: mobile storeId: 440 items: [Lcom.coffeeshop.baristastation.CoffeeShopOrderDetails$Items;@954172a6 ]
2024-09-06 17:13:04.775  INFO 39500 --- [pool-6-thread-1] c.coffeeshop.baristastation.Application  :
Publishing Order Ready:
 CoffeeShopOrderStatus [ country: uk orderId: 702 requestId: 982 source: mobile storeId: 440 status: READY ]
```
## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

See the list of [contributors](https://github.com/solacese/<github-repo>/graphs/contributors) who participated in this project.

## License

This project is licensed under the Apache License, Version 2.0. - See the [LICENSE](LICENSE) file for details.

## Resources

For more information try these resources:

- The Solace Developer Portal website at: https://solace.dev
- Solace Spring Cloud Stream binder: https://github.com/asyncapi/java-spring-cloud-stream-template
- AsyncAPI Code Generator: https://github.com/asyncapi/generator
- Ask the [Solace Community](https://solace.community)

