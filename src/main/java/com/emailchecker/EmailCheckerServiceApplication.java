package com.emailchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.emailchecker")
@EnableConfigurationProperties
public class EmailCheckerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailCheckerServiceApplication.class, args);
	}

}
