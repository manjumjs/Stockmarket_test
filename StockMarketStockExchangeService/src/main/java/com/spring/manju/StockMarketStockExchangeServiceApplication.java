package com.spring.manju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StockMarketStockExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketStockExchangeServiceApplication.class, args);
	}

}
