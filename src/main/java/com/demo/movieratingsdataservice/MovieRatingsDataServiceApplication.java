package com.demo.movieratingsdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MovieRatingsDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingsDataServiceApplication.class, args);
	}

}
