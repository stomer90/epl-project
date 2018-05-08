package com.epl.service.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EplDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EplDiscoveryServiceApplication.class, args);
	}
}
