package com.project.BuyerSignupService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BuyerSignupServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyerSignupServiceApplication.class, args);
	}

}
