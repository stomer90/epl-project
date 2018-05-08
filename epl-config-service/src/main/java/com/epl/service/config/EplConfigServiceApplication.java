package com.epl.service.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EplConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EplConfigServiceApplication.class, args);
	}
}
