package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ForsouthApplication {
	public static void main(String[] args) {
		SpringApplication.run(ForsouthApplication.class, args);
		String clientProtocols = System.getProperty("jdk.tls.client.protocols");
		System.out.println(clientProtocols);
	}

}
