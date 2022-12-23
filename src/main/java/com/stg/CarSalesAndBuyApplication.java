package com.stg;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarSalesAndBuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSalesAndBuyApplication.class, args);
		
	}
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
}
