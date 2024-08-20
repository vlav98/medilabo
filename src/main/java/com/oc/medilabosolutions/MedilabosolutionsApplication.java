package com.oc.medilabosolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MedilabosolutionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedilabosolutionsApplication.class, args);
	}

}
