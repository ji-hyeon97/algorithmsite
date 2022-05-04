package com.dku.algorithmsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContext;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AlgorithmsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmsiteApplication.class, args);
	}

}
