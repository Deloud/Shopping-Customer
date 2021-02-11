package com.shopping.shoppingmallcustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShoppingMallCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallCustomerApplication.class, args);
    }

}
