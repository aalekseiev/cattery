package com.murkino.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.murkino.repository")
@EntityScan("com.murkino.domain.*") 
public class MurkinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MurkinoApplication.class, args);
	}
	
}
