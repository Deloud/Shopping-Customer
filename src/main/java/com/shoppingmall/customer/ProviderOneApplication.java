package com.shoppingmall.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ProviderOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderOneApplication.class, args);
	}

}
