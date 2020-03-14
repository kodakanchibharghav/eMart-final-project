package com.project.SellerSignupService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class SellerSignupServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerSignupServiceApplication.class, args);
	}

}
