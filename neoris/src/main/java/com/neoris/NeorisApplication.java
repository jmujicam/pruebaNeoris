package com.neoris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.neoris.repository")
@EntityScan(basePackages = "com.neoris.entity")
@ComponentScan(basePackages = "com.neoris")
public class NeorisApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeorisApplication.class, args);
	}

}
