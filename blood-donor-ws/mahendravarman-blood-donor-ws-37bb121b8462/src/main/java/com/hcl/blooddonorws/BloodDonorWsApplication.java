package com.hcl.blooddonorws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.Logger;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class BloodDonorWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodDonorWsApplication.class, args);
	}

	@Bean
	Logger.Level feignLoggerLevel()
	{
		return Logger.Level.FULL;
	}
}
