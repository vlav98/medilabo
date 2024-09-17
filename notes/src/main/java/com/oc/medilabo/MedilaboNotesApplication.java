package com.oc.medilabo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.LocalDate;

@SpringBootApplication
@EnableDiscoveryClient
public class MedilaboNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedilaboNotesApplication.class, args);
	}

}
