package com.retail.salesorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.retail.salesorderservice")
@EnableDiscoveryClient
public class SalesOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesOrderServiceApplication.class, args);
	}
}
