package com.neoris.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.neoris.cliente.repository")
@EntityScan(basePackages = "com.neoris.cliente.entity")
@ComponentScan(basePackages = "com.neoris.cliente")
public class NeorisClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeorisClienteApplication.class, args);
	}

}
